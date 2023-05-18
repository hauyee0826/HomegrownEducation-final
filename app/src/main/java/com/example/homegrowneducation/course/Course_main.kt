package com.example.homegrowneducation.course

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.homegrowneducation.R

class Course_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.puzzle_nav_host_fragment) as NavHostFragment?


        val navController = navHostFragment!!.navController    }
}