package com.example.streethub

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.streethub.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Handle button click to navigate to SignInActivity
        binding.nextButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent) // Corrected method call
        }
    }
}
