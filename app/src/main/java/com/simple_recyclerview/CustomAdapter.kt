package com.simple_recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.simple_recyclerview.model.Contacts

class CustomAdapter(val context: Context, val contacts : List<Contacts>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout,parent, false)
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        val contacts = contacts[position]
        holder.setData(contacts,position)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentContact: Contacts? = null
        var currentPosition: Int = 0

        init {

        }

        fun setData(contacts: Contacts, position: Int) {
            val name = itemView.findViewById<TextView>(R.id.textView)

            name.text = contacts?.getCountry()

            currentContact = contacts
            currentPosition = position
        }

    }
}