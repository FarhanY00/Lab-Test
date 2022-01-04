package com.example.question2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogoutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout_page)

        var btnLogout = findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java).apply{

            }
            startActivity(intent)
        }
    }
}