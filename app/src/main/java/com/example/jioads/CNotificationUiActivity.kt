package com.example.jioads

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.reflect.typeOf


class CNotificationUiActivity : AppCompatActivity() {
    private lateinit var btnNotify:Button
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btnNotify=findViewById(R.id.btn_notification)
        var CHANNEL_ID="2nd channel"
        var NOTIFICATION_ID=88



        //convert png to bitmap
       // val drawable: Drawable? = ResourcesCompat.getDrawable(resources,R.drawable.img_1,null)
       // val bitmapDrawable:BitmapDrawable= drawable as BitmapDrawable
      //  val largeIcon:Bitmap=bitmapDrawable.bitmap




        btnNotify.setOnClickListener {
            val notificationLayout = RemoteViews(packageName, R.layout.custom_notification_ui)
            notificationLayout.setTextViewText(R.id.tv_title,"Custom Notification")
            notificationLayout.setTextViewText(R.id.tv_text,"this is Custom Notification")



            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                val nm:NotificationManager= getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                nm.createNotificationChannel(NotificationChannel(CHANNEL_ID,"ABC",NotificationManager.IMPORTANCE_LOW))
            }
            val intent = Intent(this, NotificationBroadcastReceiver::class.java)
            intent.setAction("Action")
            intent.putExtra("key","clicked")
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            val pendingIntent:PendingIntent= PendingIntent.getBroadcast(this,11111,intent,0)


            var builder: NotificationCompat.Builder
            builder  = NotificationCompat.Builder(this,CHANNEL_ID)
                // .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                //.setContentTitle("Notification")
                // .setContentText("This is notification")
                .setChannelId(CHANNEL_ID)
                .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
                .setCustomContentView(notificationLayout)
                .setTimeoutAfter(5000)
                .setContentIntent(pendingIntent)
            val mp: MediaPlayer = MediaPlayer.create(this, R.raw.notification);
            mp.start();

            with(NotificationManagerCompat.from(this)) {
                notify(NOTIFICATION_ID, builder.build())
            }

        }

    }
}