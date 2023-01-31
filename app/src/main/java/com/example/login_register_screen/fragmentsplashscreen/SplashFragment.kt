package com.example.login_register_screen.fragmentsplashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.login_register_screen.HomeActivity
import com.example.login_register_screen.MainActivity
import com.example.login_register_screen.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        val sharedPreferences = requireActivity().getSharedPreferences(
            MainActivity.sharedPreferenceData,
            AppCompatActivity.MODE_PRIVATE)

        Handler().postDelayed(Runnable {
            if (sharedPreferences.getBoolean("checkRemember", false))
            {
                startActivity(Intent(requireContext(), HomeActivity::class.java))
            }
            else
            {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)

        return view
    }
}