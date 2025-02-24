package com.example.amtccloud

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class VideoPlayerFragment : Fragment() {

    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_playback_video, container, false)
        playerView = rootView.findViewById(R.id.videoPlayer)

        hideSystemUI()
        initializePlayer()

        return rootView
    }

    private fun getStreamingUrl(): String {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> "http://192.168.5.11:5000/hls/landscape/ccb/playlist.m3u8"
            Configuration.ORIENTATION_PORTRAIT -> "http://192.168.5.11:5000/hls/portrait/vertical/playlist.m3u8"
            else -> "http://192.168.5.11:5000/hls/landscape/ccb/playlist.m3u8"
        }
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(requireContext()).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(getStreamingUrl())))
            prepare()
            playWhenReady = true
        }
        playerView.player = player
    }

    private fun hideSystemUI() {
        activity?.window?.insetsController?.apply {
            hide(WindowInsets.Type.systemBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    override fun onStart() {
        super.onStart()
        if (player == null) {
            initializePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
}
