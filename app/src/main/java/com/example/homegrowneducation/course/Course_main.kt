package com.example.homegrowneducation.course

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.CourseMainBinding

class Course_main : AppCompatActivity() {
    private lateinit var binding: CourseMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.introduceCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_main_to_course_1)
        }
        binding.additionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_main_to_course_2)
        }
        binding.subtractionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_main_to_course_3)
        }
        binding.multiplicationCourse.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_course_main_to_course_4)
        }
        binding.divisionCourse.setOnClickListener {
                view : View -> view.findNavController().navigate(R.id.action_course_main_to_course_5)
        }
    }
}