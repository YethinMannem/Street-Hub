package com.example.streethub

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.streethub.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Handle button click to navigate to SignIn through Already Have An Account Text In SignUp Page
        binding.alreadyHaveAccountButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent) // Corrected method call
        }
    }
}