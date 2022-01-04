package com.example.question1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnWeb = findViewById<Button>(R.id.btnWebAddr)
        var btnFon = findViewById<Button>(R.id.btnPhoneNo)

        btnWeb.setOnClickListener {
            var inWeb = findViewById<EditText>(R.id.etWebAddr)
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(inWeb.text.toString()))
            startActivity(intent)
        }

        btnFon.setOnClickListener {
            var inFon = findViewById<EditText>(R.id.etPhoneNo)
            val intent = Intent(Intent.ACTION_CALL);
            intent.data = Uri.parse("tel:$inFon")
            //subToast("Call Success!")
            startActivity(intent)

        }



    }
    private fun subToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}