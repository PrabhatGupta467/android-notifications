package com.example.jioads

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class NotificationBroadcastReceiver:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == "Action") {
            var show = p1?.getStringExtra("key")
            Toast.makeText(p0, show, Toast.LENGTH_SHORT).show()
        }

    }
}