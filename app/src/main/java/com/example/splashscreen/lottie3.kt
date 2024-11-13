package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splashscreen.databinding.ActivityLottie1Binding
import com.example.splashscreen.databinding.ActivityLottie3Binding

class lottie3 : AppCompatActivity() {
    private lateinit var binding: ActivityLottie3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLottie3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottietext2.setOnClickListener{
            val intent= Intent(this,login::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}