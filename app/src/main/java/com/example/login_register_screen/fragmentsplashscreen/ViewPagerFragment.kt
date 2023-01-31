package com.example.login_register_screen.fragmentsplashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.login_register_screen.R
import com.example.login_register_screen.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    var viewpager: ViewPager?=null
    lateinit var tablayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_view_pager, container, false)
        tablayout= view?.findViewById<TabLayout>(R.id.tablaysplash)!!
        viewpager=view.findViewById(R.id.viewpagerSplash)
        val fragmentList= arrayListOf<Fragment>(
            SplashFragment2(),
            SplashFragment3(),
            SplashFragment4()
        )

        val adp=ViewPagerAdapter(requireActivity().supportFragmentManager)
        viewpager?.adapter=adp
        tablayout.setupWithViewPager(viewpager)
//        TabLayoutMediator(tablayout, viewpager) { tab, position ->
//            //Some implementation...
//        }.attach()
        return view
    }
}