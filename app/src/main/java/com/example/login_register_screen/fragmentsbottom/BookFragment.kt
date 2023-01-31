package com.example.login_register_screen.fragmentsbottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.login_register_screen.R
import com.example.login_register_screen.adapters.TabAdapter
import com.google.android.material.tabs.TabLayout

class BookFragment : Fragment() {

    lateinit var tabLayout:TabLayout
    lateinit var viewPager:ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_book, container, false)

        return view
    }


}