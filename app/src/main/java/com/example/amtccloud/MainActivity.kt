package com.example.amtccloud

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            try {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_browse_fragment, VideoPlayerFragment()) // Load video player
                    .commitNow()
            } catch (e: Exception) {
                Log.e("MainActivity", "Error loading VideoPlayerFragment: ${e.message}")
            }
        }
    }
}