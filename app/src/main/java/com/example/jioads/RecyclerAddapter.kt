package com.example.jioads

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAddapter( val context : Context, val arrContact : ArrayList<ContactModel>) : RecyclerView.Adapter<RecyclerAddapter.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val image: ImageView = itemView.findViewById(R.id.imgV)
        val name: TextView = itemView.findViewById(R.id.tv_name)
       val number: TextView = itemView.findViewById(R.id.tv_number)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val temp : ContactModel=arrContact.get(position)

       holder.image.setImageResource(arrContact[position].image)
//        holder.name.text=arrContact[position].name
//        holder.number.text=arrContact[position].number
        holder.name.setText(arrContact[position].name)
        holder.number.setText(arrContact[position].number)

       holder.image.setOnClickListener {
           val intent : Intent=Intent(context,OnClickRecyclerView::class.java)
           intent.putExtra("name",temp.name)
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
           context.startActivity(intent)

       }



    }

    override fun getItemCount(): Int {
        return arrContact.size
    }
}