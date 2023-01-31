package com.example.login_register_screen.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.login_register_screen.fragmentsplashscreen.SplashFragment
import com.example.login_register_screen.fragmentsplashscreen.SplashFragment2
import com.example.login_register_screen.fragmentsplashscreen.SplashFragment3
import com.example.login_register_screen.fragmentsplashscreen.SplashFragment4

class ViewPagerAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
            return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position)
        {
            0 -> SplashFragment2()
            1 -> SplashFragment3()
            2 -> SplashFragment4()
            else -> SplashFragment2()
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab " + (position + 1)
    }



}