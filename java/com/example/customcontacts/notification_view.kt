package com.example.customcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_notification_view.*
import android.widget.Toast;
class notification_view(var t1:TextView) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_view)
        t1= findViewById(R.id.textView);
        val message=intent.getSerializableExtra("message") as String
        this.t1.text=message
    }
}
