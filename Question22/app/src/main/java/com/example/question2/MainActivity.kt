package com.example.question2

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var usernames_ = ArrayList<String>()

        //kalau db x exist, so create mydata
        if(!dbExist(this,"mydata")){
            createDB();
        }

        val db = openOrCreateDatabase("mydata", MODE_PRIVATE,null)
        val sql = "SELECT username FROM user"
        val c: Cursor = db.rawQuery(sql,null)
        while (c.moveToNext()){
            val username_ = c.getString(0)
            usernames_.add(username_)
        }
        c.close()

        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        //if()

        btnSubmit.setOnClickListener(){
            var etUname = findViewById<EditText>(R.id.etUsername)
            var etPass = findViewById<EditText>(R.id.etPassword)

            val username = etUname.text.toString()
            val password = etPass.text.toString()

            if (username=="ahmad" && password=="ahmad1234"){
                val intent = Intent(this,LogoutPage::class.java).apply{

                }
                startActivity(intent)
            }   else{
                val intent = Intent(this,MainActivity::class.java).apply{

                }
                subToast("Not match with username or password")
                startActivity(intent)
            }
//                if (!status) {
//                    val db = openOrCreateDatabase("mydata", MODE_PRIVATE, null)
//                    val sql =
//                        "INSERT INTO user (username, password) VALUES ('$username','$password');"
//                    db.execSQL(sql)
//
//                    subToast("Submit button apply")
//                }

        }


}
    private fun checkKey(username: String):Boolean{
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE, null)
        val sql = "select * from user where username='$username'"
        val cursor = db.rawQuery(sql,null)
        var out=false
        if (cursor.count > 0)
            out=true
        return out
    }

    private fun dbExist(c: Context, dbName:String ):Boolean{
        val dbFile: File = c.getDatabasePath(dbName)
        return dbFile.exists()
    }
    private fun createDB(){
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE,null)
        subToast("Database mydata created!")
        val sqlText = "CREATE TABLE IF NOT EXISTS user " +
                "(username VARCHAR(30) PRIMARY KEY, " +
                "password VARCHAR(30) NOT NULL " +
                ");"
        subToast("Table user created!")
        db.execSQL(sqlText)
        var nextSQL = "INSERT INTO user (username,password) VALUES ('ahmad','ahmad1234');"
        db.execSQL(nextSQL)
    }

    private fun subToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}