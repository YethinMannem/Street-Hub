package com.example.streethub

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.streethub.databinding.ActivitySignInBinding
import com.example.streethub.databinding.ActivityStartBinding

class SignInActivity : AppCompatActivity() {
    private val binding: ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Handle button click to navigate to SignIn through Dont Have An Account Text In SignIn Page
        binding.dontHaveAccountButton.setOnClickListener {
            val intent = Intent(this, ChooseLocationActivity::class.java)
            startActivity(intent) // Corrected method call
        }

    }
}