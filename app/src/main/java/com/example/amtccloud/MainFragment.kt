package com.example.amtccloud

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = DisplayMetrics()
        val display: Display? = activity?.getSystemService(Context.WINDOW_SERVICE)?.let {
            (it as WindowManager).defaultDisplay
        }
        display?.getMetrics(displayMetrics) // Fix for deprecated `getMetrics()`
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() { // Replaced SimpleTarget with CustomTarget
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    // Handle loaded image
                }

                override fun onLoadCleared(placeholder: android.graphics.drawable.Drawable?) {
                    // Handle cleanup
                }
            })
    }
}