package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splashscreen.databinding.ActivityLottie1Binding
import com.example.splashscreen.databinding.ActivityLottie2Binding

class lottie2 : AppCompatActivity() {
    private lateinit var binding: ActivityLottie2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLottie2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottietext2.setOnClickListener{
            val intent= Intent(this,lottie3::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}