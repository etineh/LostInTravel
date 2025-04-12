package com.allcampusapp.allcampus

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.allcampusapp.allcampus.extension.toastShort
import com.allcampusapp.allcampus.ui.WelcomeScreen
import com.allcampusapp.allcampus.ui.home.HomeActivity
import com.allcampusapp.allcampus.ui.home.LocalDarkMode
import com.allcampusapp.allcampus.ui.theme.TravelLabTheme
import com.allcampusapp.allcampus.viewModels.MainViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : ComponentActivity() {

    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private lateinit var signInLauncher: ActivityResultLauncher<IntentSenderRequest>
    private var googleIdToken: String? = null
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create ViewModel without Compose
        val viewModel: MainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        registerActivityLauncher(viewModel)

        if (auth.currentUser?.uid != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        setContent {

            TravelLabTheme(darkTheme = LocalDarkMode.current.value) {
                val isLoading by viewModel.isLoading

                LaunchedEffect(Unit) {
                    initializeGoogleSignIn()
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (isLoading) {
                        // Show loading spinner
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                        }
                    } else {
                        WelcomeScreen {
                            viewModel.setLoading(true)
                            triggerGoogleSignInFlow(viewModel)
                        }
                    }
                }

            }
        }
    }

    private fun triggerGoogleSignInFlow(viewModel: MainViewModel) {
        oneTapClient.beginSignIn(signInRequest)
            .addOnSuccessListener { result ->
                try {
                    val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent).build()
                    signInLauncher.launch(intentSenderRequest)
                } catch (e: Exception) {
                    viewModel.setLoading(false)
                    toastShort("Error occur : ${e.localizedMessage}")
                }
            }
            .addOnFailureListener { e ->
                println("General log: Error from here ${e.localizedMessage}; and $signInRequest")
                toastShort("Error occur : ${e.localizedMessage}")
                viewModel.setLoading(false)
            }
    }
//
    private fun initializeGoogleSignIn() {
        // Initialize One Tap Client
        oneTapClient = Identity.getSignInClient(this)

        // Configure the BeginSignInRequest
        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.web_client_id))
                    .setFilterByAuthorizedAccounts(false) // Optional: Only show accounts previously used
                    .build()
            )
            .setAutoSelectEnabled(true) // Optional: Skip account picker if only one account exists
            .build()
    }

    private fun registerActivityLauncher(viewModel: MainViewModel){
        signInLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->

            if(result.resultCode != RESULT_OK) {
                toastShort("Google sign-in fail")
                viewModel.setLoading(false)
                return@registerForActivityResult
            }

            try {   //  result is okay
                val credential = oneTapClient.getSignInCredentialFromIntent(result.data)
                googleIdToken = credential.googleIdToken

                registerOrSignInWithGoogle(viewModel)

            } catch (e: ApiException) {
                viewModel.setLoading(false)
                toastShort("Google sign-in fail")
                println("Google sign-in fail : ${e.localizedMessage}")
            }

        }

    }

    private fun registerOrSignInWithGoogle (viewModel: MainViewModel) {
        val googleCredential = GoogleAuthProvider.getCredential(googleIdToken, null)
        FirebaseAuth.getInstance().signInWithCredential(googleCredential)    // login existing user
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    println("Google sign-in fail : ${task.exception?.localizedMessage}")
                    toastShort("Google sign-in fail here")
                    viewModel.setLoading(false)
                    return@addOnCompleteListener
                }

                startActivity(Intent(this, HomeActivity::class.java))
                this.toastShort("Welcome on board")
                finish()
            }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelLabTheme {
        WelcomeScreen {
            println("I am click...")
        }
    }
}