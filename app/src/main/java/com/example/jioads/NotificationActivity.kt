package com.example.jioads

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.res.ResourcesCompat

class NotificationActivity : AppCompatActivity() {
    private lateinit var btnNotify:Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btnNotify=findViewById(R.id.btn_notification)
        var CHANNEL_ID="My Channel"
        var NOTIFICATION_ID=100

       /* if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            val nc:NotificationChannel= NotificationChannel("01","xyz",NotificationManager.IMPORTANCE_DEFAULT)
            val nm:NotificationManager=getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(nc)

        }
       btnNotify.setOnClickListener {
           val ncb:NotificationCompat.Builder=NotificationCompat.Builder(this,"01")
           ncb.setSmallIcon(R.drawable.ic_baseline_markunread_24)
           ncb.setContentTitle("Notification")
           ncb.setContentText("this is notification")

           val nmc:NotificationManagerCompat=NotificationManagerCompat.from(this)
           nmc.notify(1,ncb.build())
       }*/

        //convert png to bitmap
        val drawable: Drawable? = ResourcesCompat.getDrawable(resources,R.drawable.img_1,null)
        val bitmapDrawable:BitmapDrawable= drawable as BitmapDrawable
        val largeIcon:Bitmap=bitmapDrawable.bitmap


        var notification: Notification

        btnNotify.setOnClickListener {

            val nm:NotificationManager= getSystemService(NOTIFICATION_SERVICE) as NotificationManager
             if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                 notification  = Notification.Builder(this)
                     .setLargeIcon(largeIcon)
                     .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                     .setContentTitle("Notification")
                     .setContentText("This is notification")
                     .setChannelId(CHANNEL_ID)
                     .build()

                 nm.createNotificationChannel(NotificationChannel(CHANNEL_ID,"XYZ",NotificationManager.IMPORTANCE_HIGH))
             }else{
                 notification = Notification.Builder(this)
                     .setLargeIcon(largeIcon)
                     .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                     .setContentTitle("Notification")
                     .setContentText("This is notification")
                     .build()
             }
                nm.notify(NOTIFICATION_ID,notification)

        }

    }
}