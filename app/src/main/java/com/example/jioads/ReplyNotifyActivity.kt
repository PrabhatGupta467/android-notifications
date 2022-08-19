package com.example.jioads

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
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
import androidx.core.app.RemoteInput
import androidx.core.content.res.ResourcesCompat

class ReplyNotifyActivity : AppCompatActivity() {

    private lateinit var btn_replyNotify: Button


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reply_notify)

        btn_replyNotify = findViewById(R.id.btn_replyNotify)


        var Action: NotificationCompat.Action= replyAction()

        btn_replyNotify.setOnClickListener {
          //  var Action: NotificationCompat.Action= replyAction()
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Prabhat"
                val descriptionText = "Prabhat Channel"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel("808", name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

           // val intent:Intent=Intent(this,ReceiveReplyNotificationActivity::class.java)
           // val pi:PendingIntent=PendingIntent.getActivity(this,606,intent,0)

            var builder = NotificationCompat.Builder(this,"808")
                .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                .setContentTitle("Reply Notification")
                .setContentText("click below button for reply")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //.setContentIntent(pi)
                //.addAction(R.drawable.img_1,"send",pi)
                .addAction(Action)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                builder.setColor(getColor(R.color.gray))
            }


            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(5, builder.build())
            }

        }


    }

    private fun replyAction() :NotificationCompat.Action {

        var remoteInput: RemoteInput = RemoteInput.Builder("MSG")
            .setLabel("Message")
            .build()

        val intent:Intent=Intent(this,ReceiveReplyNotificationActivity::class.java)

        val pi:PendingIntent=PendingIntent.getActivity(this,607,intent,PendingIntent.FLAG_MUTABLE)


            var action: NotificationCompat.Action =
            NotificationCompat.Action.Builder(R.drawable.img_1,"Reply" ,pi)
                .addRemoteInput(remoteInput)
                .build()
         return action

    }
}
