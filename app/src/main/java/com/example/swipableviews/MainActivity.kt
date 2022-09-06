package com.example.swipableviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

private lateinit var vp : ViewPager2
private lateinit var tablayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp = findViewById(R.id.viewPagerID)
        tablayout = findViewById(R.id.tabLayout)

        val images = listOf(
            R.drawable.ji,
            R.drawable.img1,
            R.drawable.hi1,
            R.drawable.hi2,
            R.drawable.hi3,
            R.drawable.hi4,
            R.drawable.hi5,
            R.drawable.hi6,
        )
        val adapter = ViewPagerAdapter(images)
        vp.adapter = adapter

        TabLayoutMediator(tablayout,vp){ tab,position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Selected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"UnSelected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"ReSelected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

        })

    }
}