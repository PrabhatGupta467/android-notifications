package com.example.jioads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import c0.i

class OnClickRecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_click_recycler_view)
        //val tv1:TextView=findViewById(R.id.tv_1)
        val tv2:TextView=findViewById(R.id.tv_2)
        /*Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        receiver_msg.setText(str);*/
        val intent:Intent=getIntent()
        val name: String? =intent.getStringExtra("name")
        tv2.setText(name)






    }
}