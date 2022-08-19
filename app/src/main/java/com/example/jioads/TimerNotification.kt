package com.example.jioads

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import com.jio.jioads.util.Utility

class TimerNotification : AppCompatActivity() {
    private lateinit var btn_notificationtimer: Button
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_notification)
        btn_notificationtimer=findViewById(R.id.btn_notificationtimer)

        var CHANNEL_ID="xyz channel"
        var NOTIFICATION_ID=8888

        btn_notificationtimer.setOnClickListener {



            //(SystemClock.elapsedRealtime() - (10* 60000 + 0 * 1000))
            val notificationLayout = RemoteViews(packageName, R.layout.timer_notification_ui)
            notificationLayout.setTextViewText(R.id.tv_title,"Notification")
            notificationLayout.setTextViewText(R.id.tv_text,"this is Notification")
            //notificationLayout.setChronometer(R.id.chronometer, SystemClock.elapsedRealtime(),null, true)
            notificationLayout.setChronometer(R.id.chronometer, (SystemClock.elapsedRealtime() + (60* 60000 + 0 * 1000)),null, true)
            //notificationLayout.setChronometerCountDown(R.id.chronometer,true)
            notificationLayout.setChronometerCountDown(R.id.chronometer,true)




            var notification: Notification
            val nm: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
                notification  = Notification.Builder(this)
                    // .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                    //.setContentTitle("Notification")
                    // .setContentText("This is notification")
                    .setChannelId(CHANNEL_ID)
                    .setCustomContentView(notificationLayout)
                    .build()

                nm.createNotificationChannel(
                    NotificationChannel(CHANNEL_ID,"ABC",
                        NotificationManager.IMPORTANCE_HIGH)
                )
            }else{
                notification = Notification.Builder(this)
                    //.setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.ic_baseline_markunread_24)
                    //.setContentTitle("Notification")
                    //.setContentText("This is notification")
                    .setCustomContentView(notificationLayout)
                    .build()
            }
            nm.notify(NOTIFICATION_ID,notification)





        }

    }
}