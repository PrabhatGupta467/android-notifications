package com.example.jioads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class volleyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)
        val linearLayout:LinearLayout=findViewById(R.id.LinearLayout)
        loadMeme()

        linearLayout.setOnTouchListener(object : OnSwipeTouchListener(this){
            override fun onSwipeRight() {

               // Toast.makeText(this@GuestureActivity, "Swipe Right gesture detected", Toast.LENGTH_SHORT).show();
                loadMeme()
            }

            override fun onSwipeLeft() {
               // Toast.makeText(this@GuestureActivity, "Swipe Left gesture detected", Toast.LENGTH_SHORT).show();
                loadMeme()
            }


        })

    }

    private fun loadMeme() {
        val URL:String="https://meme-api.herokuapp.com/gimme/"
        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, URL, null,
            Response.Listener { response ->
               val url=response.getString("url")
                val img_view:ImageView=findViewById(R.id.ImgView)
                Glide.with(this).load(url).into(img_view);
            },
            Response.ErrorListener { error ->
                Toast.makeText(this,error.toString(),Toast.LENGTH_SHORT).show()
                Log.d("error",error.toString())
            }
        )

        queue.add(jsonObjectRequest)
    }
}