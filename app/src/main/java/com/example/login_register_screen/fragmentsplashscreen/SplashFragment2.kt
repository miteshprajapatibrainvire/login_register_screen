package com.example.login_register_screen.fragmentsplashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.login_register_screen.R

class SplashFragment2 : Fragment() {

    lateinit var btnNextId:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_splash2, container, false)
        val viewpager=activity?.findViewById<ViewPager2>(R.id.viewpager)
        btnNextId=view.findViewById(R.id.btnNextId)
        btnNextId.setOnClickListener {
            viewpager?.currentItem=1
        }

        return view

    }


}