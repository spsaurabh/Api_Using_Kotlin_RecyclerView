package com.example.api_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context , val userList:List<Data_class_01>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var t1 = itemView.findViewById<TextView>(R.id.id_01)
        var t2 = itemView.findViewById<TextView>(R.id.fname)
        var t3 = itemView.findViewById<TextView>(R.id.email)
        var t4 = itemView.findViewById<TextView>(R.id.lname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_row,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.t1.text = userList[position].id.toString()
       holder.t2.text = userList[position].first_name
       holder.t3.text = userList[position].email
       holder.t4.text = userList[position].last_name
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}