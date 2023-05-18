package com.example.homegrowneducation.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.CourseTitleBinding
import com.example.homegrowneducation.databinding.PuzzleTitleBinding

class Course_title: Fragment() {

    private lateinit var binding: CourseTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<CourseTitleBinding>(
            inflater, R.layout.course_title, container, false
        )
        binding.courseBackButton.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_title_to_main_page)
        }

        binding.introduceCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_title_to_course_1)
        }
        binding.additionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_title_to_course_2)
        }
        binding.subtractionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_title_to_course_3)
        }
        binding.multiplicationCourse.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_course_title_to_course_4)
        }
        binding.divisionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_title_to_course_5)
        }
        return binding.root
    }

}