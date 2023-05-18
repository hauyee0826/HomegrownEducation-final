package com.example.homegrowneducation.mainPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.homegrowneducation.mathquiz.Quiz_Main
import com.example.homegrowneducation.R
import com.example.homegrowneducation.course.Course_main
import com.example.homegrowneducation.databinding.MainPageBinding
import com.example.homegrowneducation.mathexec.Exec_main
import com.example.homegrowneducation.puzzle.Puzzle_main
import com.google.firebase.auth.FirebaseAuth

class MainPage : AppCompatActivity() {

    private lateinit var binding:MainPageBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val user = FirebaseAuth.getInstance().currentUser
        val displayName = user?.displayName

        if (displayName != null) {
            val textView = findViewById<TextView>(R.id.username)
            textView.text = displayName.toString()
        } else {
            Toast.makeText(this, "Display name not set", Toast.LENGTH_SHORT).show()
        }

        binding.GoProfile.setOnClickListener{
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        binding.GoQuiz.setOnClickListener{
            val intent = Intent(this, Quiz_Main::class.java)
            startActivity(intent)
        }
        binding.GoPuz.setOnClickListener {
            val intent = Intent(this, Puzzle_main::class.java)
            startActivity(intent)
        }
        binding.GoExe.setOnClickListener {
            val intent = Intent(this, Exec_main::class.java)
            startActivity(intent)
        }
        binding.GoCourse.setOnClickListener {
            val intent = Intent(this, Course_main::class.java)
            startActivity(intent)
        }

    }
}
