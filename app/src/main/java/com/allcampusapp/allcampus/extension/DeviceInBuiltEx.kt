package com.allcampusapp.allcampus.extension
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.OnBackPressedCallback

fun onBackPress(action: () -> Unit) : OnBackPressedCallback {
    return object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            action()
        }
    }
}

fun Context.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun setDelay(duration: Long = 5_000, onComplete : () -> Unit){
    Handler(Looper.getMainLooper()).postDelayed({
        onComplete()
    }, duration)
}

