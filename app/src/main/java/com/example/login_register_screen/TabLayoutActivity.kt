package com.example.login_register_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.login_register_screen.adapters.TabAdapter
import com.google.android.material.tabs.TabLayout

class TabLayoutActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        supportActionBar?.hide()
        
        tabLayout=findViewById(R.id.tabLayout)
        viewPager=findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Sport"))
        tabLayout.addTab(tabLayout.newTab().setText("Movie"))
        tabLayout.tabGravity=TabLayout.GRAVITY_FILL

        val adapter= TabAdapter(this,supportFragmentManager,tabLayout!!.tabCount)
        viewPager!!.adapter=adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }
}