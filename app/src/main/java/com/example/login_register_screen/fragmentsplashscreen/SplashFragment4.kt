package com.example.login_register_screen.fragmentsplashscreen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.login_register_screen.HomeActivity
import com.example.login_register_screen.MainActivity
import com.example.login_register_screen.R

class SplashFragment4 : Fragment() {

lateinit var btnNext:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_splash4, container, false)
        btnNext=view.findViewById(R.id.btnIdNext)
        btnNext.setOnClickListener {
            val sharedPreferences=requireContext().getSharedPreferences(
                MainActivity.sharedPreferenceData,
                AppCompatActivity.MODE_PRIVATE
            )

            if(sharedPreferences.getBoolean("checkRemember",false))
            {
                startActivity(Intent(requireContext(),HomeActivity::class.java))
            }
            else
            {
                startActivity(Intent(requireContext(),MainActivity::class.java))
            }
        }

        return view
    }
}