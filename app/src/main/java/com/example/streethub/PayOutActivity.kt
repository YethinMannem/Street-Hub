package com.example.streethub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.streethub.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPayOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.placeMyOrderButton.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager, "CongratsBottomSheet")
        }
    }
}
