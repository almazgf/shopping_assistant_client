package com.example.shopping_assistant_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComposeAdapter(private val acceptIngredients: ArrayList<String>,
                     private val unAcceptIngredients: ArrayList<String>) : RecyclerView.Adapter<ComposeAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val listItem: TextView = view.findViewById<View>(R.id.list_item) as TextView
            //val listItem2: TextView = view.findViewById<View>(R.id.list_item2) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemView = LayoutInflater.from(parent.context)
         .inflate(R.layout.copose_item,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: String = acceptIngredients[position]
        if(item in unAcceptIngredients){
            holder.listItem.setTextColor(android.graphics.Color.RED)
        }else {
            holder.listItem.setTextColor(android.graphics.Color.GREEN)
        }
        holder.listItem.text = item
    }

    override fun getItemCount(): Int {
        return acceptIngredients.size
    }

}