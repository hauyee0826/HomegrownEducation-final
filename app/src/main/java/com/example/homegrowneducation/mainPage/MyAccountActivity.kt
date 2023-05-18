package com.example.homegrowneducation.mainPage

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.homegrowneducation.R

import com.example.homegrowneducation.databinding.ActivityMyaccountBinding
import com.example.homegrowneducation.loginRegister.LoginActivity
import com.example.homegrowneducation.mathquiz.Quiz_Page
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.jakewharton.rxbinding2.widget.RxTextView

@SuppressLint("CheckResult")
class MyAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyaccountBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyaccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //auth
        auth = FirebaseAuth.getInstance()


        val user = FirebaseAuth.getInstance().currentUser
        val displayName = user?.displayName

        binding.backbtn.setOnClickListener{
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        binding.btnchangename.setOnClickListener{
            val newname = binding.etnewname.text.toString().trim()

            changeName(newname)
        }

        if (displayName != null) {
            val textView = findViewById<TextView>(R.id.username)
            textView.text = displayName.toString()
        } else {
            Toast.makeText(this, "Display name not set", Toast.LENGTH_SHORT).show()
        }

        //email validation
        val emailStream= RxTextView.textChanges(binding.etresetemail)
            .skipInitialValue()
            .map { email ->
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            }
        emailStream.subscribe {
            showEmailValidAlert(it)
        }

        //reset password
        binding.btnresetpage.setOnClickListener{
            val email = binding.etresetemail.text.toString().trim()
            auth.sendPasswordResetEmail(email).addOnCompleteListener(this){ reset ->
                if (reset.isSuccessful){
                    Intent(this, LoginActivity::class.java).also{
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Password have been reset, please check your email!", Toast.LENGTH_SHORT).show()
                    }
                }else {
                    Toast.makeText(this, reset.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        //click

    }



    private fun changeName(newname:String){
        val user = FirebaseAuth.getInstance().currentUser
        val newDisplayName = binding.etnewname.text.toString()

        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(newDisplayName)
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MyAccountActivity::class.java))
                    Toast.makeText(this, "Display name updated", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error updating display name", Toast.LENGTH_SHORT).show()
                }
            }

    }


    private fun showEmailValidAlert(isNotValid: Boolean){
        if (isNotValid){
            binding.etresetemail.error = "Email is not valid!"
            binding.btnresetpage.isEnabled = false
            binding.btnresetpage.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)}
        else{
            binding.etresetemail.error = null
            binding.btnresetpage.isEnabled = true
            binding.btnresetpage.backgroundTintList = ContextCompat.getColorStateList(this, R.color.primary_color)

        }
    }
}