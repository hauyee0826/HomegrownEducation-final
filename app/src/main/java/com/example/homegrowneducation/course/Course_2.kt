package com.example.homegrowneducation.course

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.Course2Binding

class Course_2 : Fragment() {

    var videoView: VideoView?= null
    var mediaController: MediaController?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<Course2Binding>(
            inflater, R.layout.course_2, container, false
        )

        binding.courseBackButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_2_to_course_main)
        }

        var videoView = binding.courseVideo as VideoView?

        if (mediaController == null) {
            mediaController = MediaController(this.activity)
            mediaController!!.setAnchorView(this.videoView)
        }
        videoView!!.setMediaController(mediaController)

        videoView!!.setVideoURI(Uri.parse("android.resource://${activity?.packageName}/" + R.raw.course2))

        videoView!!.requestFocus()
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            Toast.makeText(context, "Video End", Toast.LENGTH_LONG).show()
        }

        videoView!!.setOnErrorListener { mediaPlayer, i , i2 ->
            Toast.makeText(context, "Error Occured", Toast.LENGTH_LONG).show()
            false}

        return binding.root
    }
}
