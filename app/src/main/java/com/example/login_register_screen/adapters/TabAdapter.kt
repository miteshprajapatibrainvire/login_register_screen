package com.example.login_register_screen.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.login_register_screen.fragmentsplashscreen.MovieFragment
import com.example.login_register_screen.fragmentsplashscreen.SportFragment

open class TabAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    internal var totalTabs: Int
) : FragmentPagerAdapter(fm)
{
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return SportFragment()
            }
            1 -> {
                return MovieFragment()
            }
            else -> {
                return Fragment()
            }
        }
    }

}