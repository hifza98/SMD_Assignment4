package com.example.customcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*
import android.content.Intent
class details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val contact = intent.getSerializableExtra("detail") as Contacts
        this.text1.text=contact.firstname
        this.text2.text=contact.cnumber
        this.text3.text=contact.cemail
    }
}
