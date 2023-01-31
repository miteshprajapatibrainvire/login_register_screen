package com.example.login_register_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.login_register_screen.adapters.ItemAdapter
import com.example.login_register_screen.databinding.ActivityLoginBinding
import com.example.login_register_screen.databinding.ActivityMainBinding
import com.example.login_register_screen.models.DataModel

class MainActivity : AppCompatActivity() {

    companion object{
        val sharedPreferenceData:String="sharedData"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)

        if(sharedPreferences.getBoolean("checkRemember",false))
        {
            startActivity(Intent(this,HomeActivity::class.java))
        }

        binding.idLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        binding.btSingupid.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }
}