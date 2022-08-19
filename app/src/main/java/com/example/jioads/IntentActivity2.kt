package com.example.jioads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentActivity2 : AppCompatActivity() {
    private  lateinit var tv_show:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)
        tv_show=findViewById(R.id.tv_show)

        val intent:Intent= intent
        var ans: String? =intent.getStringExtra("key")
        tv_show.text="Hi $ans"

    }
}