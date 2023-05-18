package com.example.homegrowneducation.loginRegister

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.homegrowneducation.mainPage.MainPage
import com.example.homegrowneducation.mainPage.MyAccountActivity
import com.example.homegrowneducation.R
import com.example.homegrowneducation.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable

@SuppressLint("CheckResult")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//Auth
        auth = FirebaseAuth.getInstance()



//email validation
        val emailStream = RxTextView.textChanges(binding.etloginemail)
            .skipInitialValue()
            .map { email ->
                email.isEmpty()
            }
        emailStream.subscribe {
            showTextMinimalAlert(it,"Email")
        }

//password validation
        val passwordStream = RxTextView.textChanges(binding.etloginpassword)
            .skipInitialValue()
            .map { name ->
                name.isEmpty()
            }
        passwordStream.subscribe {
            showTextMinimalAlert(it,"Password")
        }

        //button enable true or false
        val invalidFieldStream = Observable.combineLatest(
            emailStream,
            passwordStream,
         { emailInvalid: Boolean, passwordInvalid: Boolean ->
            !emailInvalid && !passwordInvalid
        }        )
        invalidFieldStream.subscribe{
                isValid ->
            if (isValid){
                binding.btnloginpage.isEnabled = true
                binding.btnloginpage.backgroundTintList = ContextCompat.getColorStateList(this, R.color.colorPrimary)}
            else{
                binding.btnloginpage.isEnabled = false
                binding.btnloginpage.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)}
        }

//click
        binding.btnloginpage.setOnClickListener{
            val email = binding.etloginemail.text.toString().trim()
            val password = binding.etloginpassword.text.toString().trim()
            loginUser(email, password)
        }

        binding.tvlogintoregister.setOnClickListener{
            startActivity(Intent(this, RegisterAcitivity::class.java))
        }
        binding.tvforgotpass.setOnClickListener {
            startActivity(Intent(this, MyAccountActivity::class.java))
        }
    }
    private fun showTextMinimalAlert(isNotValid: Boolean, text: String){
        if (text == "Email")
            binding.etloginemail.error = if (isNotValid) "$text cannot be blank!" else null
        else if (text == "Password")
            binding.etloginpassword.error = if (isNotValid) "$text cannot be blank!" else null
    }

    private fun loginUser(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                login -> if(login.isSuccessful){
                    Intent(this, MainPage::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                    }
            }else {
                Toast.makeText(this, login.exception?.message, Toast.LENGTH_SHORT).show()
            }
            }
    }
}