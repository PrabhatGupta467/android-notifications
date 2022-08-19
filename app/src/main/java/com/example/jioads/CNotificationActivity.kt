package com.example.jioads

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
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

class CNotificationActivity : AppCompatActivity() {
    private lateinit var btnNotify:Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cnotification)

        btnNotify=findViewById(R.id.btn_cnotification)
        var CHANNEL_ID="My Custom Channel"
        var NOTIFICATION_ID=99
        var REQ_CODE=99



        //convert png to bitmap
        val drawable: Drawable? = ResourcesCompat.getDrawable(resources,R.drawable.img_1,null)
        val bitmapDrawable:BitmapDrawable= drawable as BitmapDrawable
        val largeIcon:Bitmap=bitmapDrawable.bitmap


        var notification: Notification

        btnNotify.setOnClickListener {
            val notify:Intent=Intent(this,volleyActivity::class.java)
            notify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pi:PendingIntent=PendingIntent.getActivity(applicationContext,REQ_CODE,notify,PendingIntent.FLAG_IMMUTABLE)


            val nm:NotificationManager= getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            //big picture style
            val bigPictureStyle:Notification.BigPictureStyle=Notification.BigPictureStyle()
                .bigPicture(largeIcon)
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("message")
                .setSummaryText("image message")
            //inbox style
            var inboxStyle:Notification.InboxStyle=Notification.InboxStyle()
                .addLine("A basic notification usually includes a title,")
                .addLine("a line  of text, and one or more  actions the ")
                .addLine("user can perform  in response. To provide even")
                .addLine("more information, you can  also  create large,")
                .addLine("expandable notifications  by  applying  one of")
                .addLine("several notification templates as described on")
                .addLine("this page.")
                .addLine("h")
                .addLine("i")
                .addLine("j")
                .addLine("k")
                .addLine("l")
                .addLine("m")
                .addLine("n")
                .addLine("o")
                .addLine("p")
                .addLine("q")
                .setBigContentTitle("full message")
                .setSummaryText("text message")



            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                notification  = Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                    .setContentTitle("Notification")
                    .setContentText("This is notification")
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                   // .setAutoCancel(false)
                    //.setOngoing(true)
                    .build()

                nm.createNotificationChannel(NotificationChannel(CHANNEL_ID,"XYZ",NotificationManager.IMPORTANCE_HIGH))
            }else{
                notification = Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                    .setContentTitle("Notification")
                    .setContentText("This is notification")
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    //.setAutoCancel(false)
                  //  .setOngoing(true)
                    .build()
            }
            nm.notify(NOTIFICATION_ID,notification)

        }

    }
}