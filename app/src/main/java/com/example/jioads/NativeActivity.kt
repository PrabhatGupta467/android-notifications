package com.example.jioads

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.core.content.getSystemService
import com.jio.jioads.adinterfaces.JioAdError
import com.jio.jioads.adinterfaces.JioAdListener
import com.jio.jioads.adinterfaces.JioAdView

class NativeActivity : AppCompatActivity() {
    var jioAdViewNative : JioAdView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native)

        val btn_cacheAd: Button = findViewById(R.id.cacheAd)
        val btn_loadAD: Button = findViewById(R.id.loadAd)

        btn_cacheAd.setOnClickListener {
            cacheAdMethod()
        }

        btn_loadAD.setOnClickListener {
            showAdMethod()
        }


    }

    override fun onDestroy() {
        jioAdViewNative!!.onDestroy()
        super.onDestroy()
    }

    private fun showAdMethod() {
        if(jioAdViewNative!!.getAdState() == JioAdView.AdState.PREPARED){
            val adContainer = findViewById<FrameLayout>(R.id.adview)
            adContainer.removeAllViews()
            adContainer.addView(jioAdViewNative)
            adContainer.visibility = View.VISIBLE
            jioAdViewNative!!.loadAd()
        }


    }

    private fun cacheAdMethod() {
        /*JioAdView jioAdViewNative = new JioAdView(this, <ADSPOT_KEY_GOES_HERE>, <UX_TYPE_GOES_HERE>);*/
        jioAdViewNative = JioAdView(this, "on6f2u7c", JioAdView.AD_TYPE.CUSTOM_NATIVE)
        jioAdViewNative!!.setAdListener(object : JioAdListener() {
            override fun onAdClosed(
                jioAdView: JioAdView?,
                isVideoCompleted: Boolean,
                isEligibleForReward: Boolean
            ) {
                Log.i("onAdClosed", "Inside onAdClosed")
            }

            override fun onAdFailedToLoad(jioAdView: JioAdView?, jioAdError: JioAdError?) {
                Log.i("onAdFailedToLoad", "Inside onAdFailedToLoad")
            }

            override fun onAdMediaEnd(jioAdView: JioAdView?) {
                Log.i("onAdMediaEnd", "Inside onAdMediaEnd")
            }

            override fun onAdPrepared(jioAdView: JioAdView?) {
                Log.i("onAdPrepared", "Inside onAdPrepared")
                findViewById<Button>(R.id.loadAd).isEnabled = true
            }

            override fun onAdRender(jioAdView: JioAdView?) {
                Log.i("onAdRender", "Inside onAdRender")
            }
        })
        jioAdViewNative!!.setCustomImageSize(312, 211)
        jioAdViewNative!!.setCustomNativeAdContainer(R.layout.native_view)
        jioAdViewNative!!.cacheAd()
    }
}