package com.example.homegrowneducation.puzzle

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.homegrowneducation.R as res


class Puzzle_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(res.layout.puzzle_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(res.id.puzzle_nav_host_fragment) as NavHostFragment?


        val navController = navHostFragment!!.navController

    }

}