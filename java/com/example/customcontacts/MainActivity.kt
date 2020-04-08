package com.example.customcontacts

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationBuilderWithBuilderAccessor
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.NotificationCompat



class MainActivity : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId ="package com.example.customcontacts"
    private val description="has been added to contacts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val db = Datbase_Helper(this)
        save.setOnClickListener()
        {

           // startActivity(Intent(applicationContext, contactlist::class.java))
            val s1 = edt1.text.toString()
            val s2 = edt2.text.toString()
            val s3 = edt3.text.toString()
            val s4 = edt4.text.toString()
            if (s1 == "" || s2 == "" || s3 == "" || s4 == "") {
                Toast.makeText(applicationContext, "Fields are empty", Toast.LENGTH_SHORT).show()
            } else {

                val insert = db.insert(s1, s2, s3, s4)
                val intent=Intent(this,contactlist::class.java)
                val pendingIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel=NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
                    notificationManager.createNotificationChannel(notificationChannel)
                    builder= Notification.Builder(this,channelId)
                        .setContentTitle("Contacts custom")
                        .setContentText(s1+" "+s2+" "+description)
                        .setSmallIcon(R.drawable.ic_message)
                        pendingIntent.send()

                }
                else
                {
                    builder= Notification.Builder(this)
                        .setContentTitle("Contacts custom")
                        .setContentText(s1+" "+s2+" "+description)
                        .setSmallIcon(R.drawable.ic_message)
                    pendingIntent.send()
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    notificationManager.notify(1234,builder.build())
                }
            }
        }


    }
}


