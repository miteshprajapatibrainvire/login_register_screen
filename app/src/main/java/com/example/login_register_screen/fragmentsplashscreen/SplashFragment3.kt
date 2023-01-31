package com.example.login_register_screen.fragmentsplashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.login_register_screen.R

class SplashFragment3 : Fragment() {

lateinit var btnNextId2:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_splash3, container, false)
        btnNextId2=view.findViewById(R.id.btnIdNext2)
        val viewpager=activity?.findViewById<ViewPager2>(R.id.viewpager)
        btnNextId2.setOnClickListener {
            viewpager?.currentItem=2
        }
        return view
    }


}