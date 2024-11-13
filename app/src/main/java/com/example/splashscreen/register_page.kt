package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.splashscreen.databinding.ActivityRegisterPageBinding
import com.google.firebase.auth.FirebaseAuth

class register_page : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPageBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.register4.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)

        }
        binding.registerbutton.setOnClickListener {
            val email = binding.registeremail.text.toString()
            val pass = binding.registerpass.text.toString()
            val branch = binding.registerbranch.text.toString()
            val username = binding.registerusername.text.toString()
            val year = binding.registeryear.text.toString()
            val admission = binding.registeraddmissionno.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && branch.isNotEmpty() && username.isNotEmpty() && year.isNotEmpty() && admission.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, login::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "FIll ALL THE CREDENTIALS", Toast.LENGTH_SHORT).show()
            }

        }
    }
    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}