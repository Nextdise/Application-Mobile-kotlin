package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activit_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activit_main)

        btnList.setOnClickListener{
            val intent = Intent(this,List2::class.java)
            startActivity(intent)
        }
        btnCalculatrice.setOnClickListener{
            val intent = Intent(this,Calculatrice::class.java)
            startActivity(intent)
        }


    }
}