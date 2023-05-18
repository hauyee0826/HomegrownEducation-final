package com.example.homegrowneducation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homegrowneducation.mainPage.MainPage
import com.example.homegrowneducation.loginRegister.LoginActivity
import com.example.homegrowneducation.loginRegister.RegisterAcitivity
import com.example.homegrowneducation.databinding.IntroBinding
import com.google.firebase.auth.FirebaseAuth

class Intro : AppCompatActivity() {

    private lateinit var binding: IntroBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnregister.setOnClickListener{
            startActivity(Intent(this, RegisterAcitivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this, MainPage::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}