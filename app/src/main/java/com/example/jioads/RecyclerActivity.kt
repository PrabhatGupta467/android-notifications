package com.example.jioads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val arrContact =ArrayList<ContactModel>()//for dataset

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        recyclerView.layoutManager=LinearLayoutManager(this) //setting layout manager...

     arrContact.add(ContactModel(R.drawable.img,"ram","7880041022"))//setting the data
     arrContact.add(ContactModel(R.drawable.img,"shyam","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"gita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"jeetu","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"rohit","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mahendra","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"virat","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pratik","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pranav","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"ram","7880041022"))//setting the data
     arrContact.add(ContactModel(R.drawable.img,"shyam","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"gita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"jeetu","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"rohit","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mahendra","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"virat","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pratik","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pranav","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"ram","7880041022"))//setting the data
     arrContact.add(ContactModel(R.drawable.img,"shyam","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sohan","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"sita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"gita","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"jeetu","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"rohit","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"mahendra","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"virat","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pratik","7880041022"))
     arrContact.add(ContactModel(R.drawable.img,"pranav","7880041022"))




        val recycler = RecyclerAddapter(this,arrContact)

        recyclerView.adapter=recycler
        //recycler.notifyDataSetChanged()

    }
}