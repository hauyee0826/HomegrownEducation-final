package com.example.homegrowneducation.mainPage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.ActivityProfileBinding
import com.example.homegrowneducation.loginRegister.LoginActivity
import com.google.firebase.auth.FirebaseAuth


class ProfilePage: AppCompatActivity(){

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityProfileBinding.inflate(layoutInflater)

        auth = FirebaseAuth.getInstance()
        setContentView(binding.root)

        val user = auth.currentUser
        val displayName = user?.displayName
        val displayEmail = user?.email

        if (displayName != null) {
            val textView = findViewById<TextView>(R.id.username)
            textView.text = displayName.toString()
        } else {
            Toast.makeText(this, "Display name not set", Toast.LENGTH_SHORT).show()
        }

        if (displayEmail != null) {
            val textView = findViewById<TextView>(R.id.gmail)
            textView.text = displayEmail.toString()
        } else {
            Toast.makeText(this, "Display email not set", Toast.LENGTH_SHORT).show()
        }

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }

        binding.aboutUsArrow.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_profilePage_to_aboutUs)
        }
        binding.myAccountArrow.setOnClickListener { view: View ->
            val intent = Intent(this, MyAccountActivity::class.java)
            startActivity(intent)
        }

        binding.logoutArrow.setOnClickListener { view: View ->
            auth.signOut()
            Intent(this, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}