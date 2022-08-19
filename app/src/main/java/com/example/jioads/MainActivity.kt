package com.example.jioads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.jio.jioads.adinterfaces.JioAds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val btn_intent : Button= findViewById(R.id.btn_intent)
//        val btn_Interstitial : Button = findViewById(R.id.btn_Interstitial)
//        val btn_Recycler: Button = findViewById(R.id.btn_Recycler)
//        val btn_nativeAds : Button=findViewById(R.id.native_ads)
//        val btn_volley :Button= findViewById(R.id.btn_volley);
//        val btn_fwvp:Button=findViewById(R.id.btn_fwvp)
        val btn_notify:Button=findViewById(R.id.btn_notify)
        val btn_cnotify:Button=findViewById(R.id.btn_cnotify)
        val btn_cnotifyui:Button=findViewById(R.id.btn_cnotifyui)
        val btn_replynotify:Button=findViewById(R.id.btn_replynotify)
        val btn_timernotification:Button=findViewById(R.id.btn_timernotification)
//        val btn_mqtt:Button=findViewById(R.id.btn_mqtt)

        JioAds.getInstance().setLogLevel(JioAds.LogLevel.DEBUG)
        JioAds.getInstance().setEnvironment(JioAds.Environment.PROD) //****** 3 types of environment-->STG,PROD,SIT
        JioAds.getInstance().init(this)

//        btn_intent.setOnClickListener {
//            intentActivity()
//        }
//        btn_Interstitial.setOnClickListener {
//            interstitialAds()
//        }
//        btn_Recycler.setOnClickListener {
//            recyclerActivity()
//        }
//
//        btn_nativeAds.setOnClickListener {
//            nativeActivity()
//        }
//        btn_volley.setOnClickListener {
//            VolleyActivity()
//        }
//        btn_fwvp.setOnClickListener {
//            fwvpActivity()
//        }
        btn_notify.setOnClickListener {
            notifyActivity()
        }
        btn_cnotify.setOnClickListener {
            cnotifyActivity()
        }
        btn_cnotifyui.setOnClickListener {
            cnotifyuiActivity()
        }
        btn_replynotify.setOnClickListener {
            replyNotifyActivity()
        }
        btn_timernotification.setOnClickListener {
            timernotificationActivity()
        }
//        btn_mqtt.setOnClickListener {
//            mqttActivity()
//        }
    }

    private fun timernotificationActivity() {
        Toast.makeText(this,"timer notification button clicked",Toast.LENGTH_SHORT).show()
        val tn:Intent=Intent(this,TimerNotification::class.java)
        startActivity(tn)
    }

    private fun mqttActivity() {
        Toast.makeText(this,"mqtt button clicked",Toast.LENGTH_SHORT).show()
        val mqtt:Intent=Intent(this,MqttActivity::class.java)
        startActivity(mqtt)
    }

    private fun replyNotifyActivity() {
        Toast.makeText(this,"notification reply button clicked",Toast.LENGTH_SHORT).show()
        val replyNotifyIntent:Intent=Intent(this,ReplyNotifyActivity::class.java)
        startActivity(replyNotifyIntent)
    }

    private fun cnotifyuiActivity() {
        Toast.makeText(this,"custom notification button clicked",Toast.LENGTH_SHORT).show()
        val cnotifyuiIntent:Intent=Intent(this,CNotificationUiActivity::class.java)
        startActivity(cnotifyuiIntent)
    }

    private fun cnotifyActivity() {
        Toast.makeText(this,"Expandable notification button clicked",Toast.LENGTH_SHORT).show()
        val cnotifyIntent:Intent=Intent(this,CNotificationActivity::class.java)
        startActivity(cnotifyIntent)
    }

    private fun notifyActivity() {
        Toast.makeText(this,"notification button clicked",Toast.LENGTH_SHORT).show()
        val notifyIntent:Intent=Intent(this,NotificationActivity::class.java)
        startActivity(notifyIntent)
    }

    private fun fwvpActivity() {
        Toast.makeText(this,"Fragment with ViewPager button clicked",Toast.LENGTH_SHORT).show()
        val intentFWVP:Intent=Intent(this,FwvpActivity::class.java)
        startActivity(intentFWVP)
    }

    private fun VolleyActivity() {
        Toast.makeText(this,"volley button clicked",Toast.LENGTH_SHORT).show()
        val vollyIntent=Intent(this,volleyActivity::class.java)
        startActivity(vollyIntent)
    }

    private fun nativeActivity() {
        Toast.makeText(this,"native ads button clicked",Toast.LENGTH_SHORT).show()
        val nativeIntent= Intent(this,NativeActivity::class.java)
        startActivity(nativeIntent)

    }

    private fun recyclerActivity() {
        Toast.makeText(this,"Recycler button clicked",Toast.LENGTH_SHORT).show()
        val intentRecycler=Intent(this,RecyclerActivity::class.java)
        startActivity(intentRecycler)
    }

    private fun interstitialAds() {
        Toast.makeText(this,"Interstitial ads button clicked",Toast.LENGTH_SHORT).show()
        val intentIA=Intent(this,InterstitialAds::class.java)
        startActivity(intentIA)
    }

    private fun intentActivity() {
        Toast.makeText(this,"intent button clicked",Toast.LENGTH_SHORT).show()
        val intent=Intent(this,IntentActivity1::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        JioAds.getInstance().release();
    }

}