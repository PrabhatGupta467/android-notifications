package com.example.jioads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import com.jio.jioads.adinterfaces.JioAdError
import com.jio.jioads.adinterfaces.JioAdListener
import com.jio.jioads.adinterfaces.JioAdView

class InterstitialAds : AppCompatActivity() {
    private var InterstitialAdView: JioAdView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial_ads)
        val btn_cacheAd : Button = findViewById(R.id.cacheAd)
        val btn_loadAd : Button =findViewById(R.id.loadAd)

        btn_cacheAd.setOnClickListener {
            startChaceAd()
        }
        btn_loadAd.setOnClickListener {
            startShowAd()
        }
    }
    override fun onDestroy() {
        InterstitialAdView?.onDestroy()
        super.onDestroy()
    }

    private fun startChaceAd() {

        InterstitialAdView =JioAdView(this,"rnfxw1by",JioAdView.AD_TYPE.INTERSTITIAL)
        InterstitialAdView!!.setAdListener(object : JioAdListener(){
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
            override fun onAdClicked(jioAdView: JioAdView?) {
                Log.i("onAdClicked", "Inside onAdClicked")
                super.onAdClicked(jioAdView)
            }

        })
      InterstitialAdView!!.cacheAd()

    }

    private fun startShowAd() {

        if(InterstitialAdView!!.getAdState() == JioAdView.AdState.PREPARED){
            val adContainer = findViewById<FrameLayout>(R.id.instreamAdContainer)
            adContainer.removeAllViews()
            adContainer.addView(InterstitialAdView)
            adContainer.visibility = View.VISIBLE
            InterstitialAdView!!.loadAd()
        }

    }
}