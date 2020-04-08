package com.example.customcontacts

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var contacts: ArrayList<Contacts>) : BaseAdapter() {
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return contacts.count()
    }

    override fun getItem(position: Int): Any {
        return contacts.get(position)
    }

    private class ViewHolder(row : View?){
        var fname:TextView = row?.findViewById(R.id.txt1) as TextView
        var lname:TextView = row?.findViewById(R.id.txt2) as TextView

    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view_check:View?
        var viewHolder:ViewHolder
        if(view==null)
        {
            var layout= LayoutInflater.from(context)
            view_check=layout.inflate(R.layout.activity_contactlist,parent,false)
            viewHolder=ViewHolder(view_check)
            view_check.tag=viewHolder
        }
        else
        {
            view_check=view
            viewHolder=view_check.tag as ViewHolder
        }
        var contacts:Contacts=getItem(position) as Contacts
        viewHolder.fname.text=contacts.firstname
        viewHolder.lname.text=contacts.lastname
        return view_check as View

    }
    }