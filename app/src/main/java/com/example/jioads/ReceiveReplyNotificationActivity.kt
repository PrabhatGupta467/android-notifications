package com.example.jioads

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput

class ReceiveReplyNotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_reply_notification)
        var tv:TextView=findViewById(R.id.tv_receive)


        val intent:Intent=intent
        val messageText = getMessageText(intent)
        tv.text=messageText.toString()
        // tv.text="prabhat"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "stu"
            val descriptionText = "stu Channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("809", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

      //  val intent:Intent=Intent(this,ReceiveReplyNotificationActivity::class.java)
        //val pi: PendingIntent = PendingIntent.getActivity(this,606,intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this,"809")
            .setSmallIcon(R.drawable.ic_baseline_markunread_24)
            .setContentTitle("Reply Notification")
            .setContentText("send")
            //.setPriority(NotificationCompat.PRIORITY_DEFAULT)
            //.setContentIntent(pi)
            //.addAction(R.drawable.img_1,"send",pi)
            //.addAction(Action)


        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(5, builder.build())
        }





    }
    private fun getMessageText(intent: Intent): CharSequence? {
        return RemoteInput.getResultsFromIntent(intent)?.getCharSequence("MSG")
    }


}