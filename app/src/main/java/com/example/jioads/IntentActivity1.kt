package com.example.jioads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import c0.i

class IntentActivity1 : AppCompatActivity() {
    private lateinit var et:EditText
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)
        et=findViewById(R.id.et)
        btn=findViewById(R.id.btn)

        btn.setOnClickListener {
            val intent: Intent =Intent(this,IntentActivity2::class.java)
            intent.putExtra("key",et.text.toString())
            startActivity(intent)
        }

    }
}