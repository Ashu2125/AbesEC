package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splashscreen.databinding.ActivityLottie1Binding

class lottie1 : AppCompatActivity() {
    private lateinit var binding:ActivityLottie1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLottie1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottietext2.setOnClickListener{
            val intent= Intent(this,lottie2::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }
    }
}