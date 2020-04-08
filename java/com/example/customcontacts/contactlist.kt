package com.example.customcontacts

import android.content.Intent
import android.icu.text.IDNA
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contactlist.*
class contactlist : AppCompatActivity() {
    private lateinit var contactlist: List<Contacts>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactlist)
        viewData()
        val listView = findViewById<View>(R.id.listView) as ListView
        listView.setOnItemClickListener { _, _, point, _ ->

            val intent = Intent(applicationContext, details::class.java)
            intent.putExtra("detail",contactlist[point])
            startActivity(intent)
        }
    }
    private fun viewData()
    {
        val datahelper: Datbase_Helper= Datbase_Helper(this)
        contactlist = datahelper.ReadContact()
        val listView = findViewById<ListView>(R.id.listView)
        //creating custom ArrayAdapter
        val CustomListAdapter = CustomAdapter(this,contactlist as ArrayList<Contacts>)
        listView.adapter = CustomListAdapter
    }
}
