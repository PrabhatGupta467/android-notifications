package com.example.jioads

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FwvpActivity : AppCompatActivity() {
    private lateinit var tablayout: TabLayout
    private lateinit var viewpager:ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fwvp)
        tablayout=findViewById(R.id.tabLayout)
        viewpager=findViewById(R.id.viewPager)

      viewpager.adapter=PagerAdapter(this)
        TabLayoutMediator(tablayout, viewpager) { tab, position ->
            tab.text = when(position){
                0->{"first"}
                1->{"second"}
                2->{"third"}
                else->{throw Resources.NotFoundException("position not found")}
            }
        }.attach()


}

}