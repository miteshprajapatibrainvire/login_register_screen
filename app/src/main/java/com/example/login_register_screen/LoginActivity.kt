package com.example.login_register_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.login_register_screen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var fullName: String
    lateinit var password: String
    lateinit var email: String
//    lateinit var checkRememberMe:CheckBox
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sharedPreferences =
            getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        if (sharedPreferences.getString(
                "email", null
            ) != null && sharedPreferences.getString("password", null) != null
        ) {
            fullName = sharedPreferences.getString("fullName", null)!!
            password = sharedPreferences.getString("password", null)!!
            email = sharedPreferences.getString("email", null)!!
        }

        binding.imgBackPress.setOnClickListener {
            onBackPressed()
        }

        binding.txSingUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btlog.setOnClickListener {
            if (validation()) {
                val emailString = binding.edEmail.text
                val recentPassword = binding.edPass.text
                if (sharedPreferences.getString(
                        "email", null
                    ) == null && sharedPreferences.getString("password", null) == null
                ) {
                    Toast.makeText(this, "Register your account!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    if (email.equals(emailString.toString()) && recentPassword.toString()
                            .equals(password)
                    ) {

                        if(binding.idCheckBox.isChecked)
                        {
                            myEdit.putBoolean("checkRemember",true)
                            myEdit.commit()
                        }
                        else
                        {
                            myEdit.putBoolean("checkRemember",false)
                            myEdit.commit()
                        }

                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show()
                        val intHome = Intent(this, HomeActivity::class.java)
                        intHome.putExtra("emailString", emailString.toString())
                        intHome.putExtra("password", recentPassword.toString())
                        startActivity(intHome)

                    }
                    else
                    {
                        Toast.makeText(
                            this, "Invalide Cradencials Register your account?", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }

    private fun validation(): Boolean {

        if (binding.edEmail.text!!.isEmpty()) {
            binding.edEmail.error = "Enter Full Name!"
            binding.edEmail.requestFocus()
            return false
        } else {
            binding.edEmail.error = null
        }

        if (binding.edPass.text!!.isEmpty()) {
            binding.edPass.error = "Enter Password!"
            binding.edPass.requestFocus()
            return false
        } else {
            binding.edPass.error = null
            if (binding.edPass.length() < 6)
            {
                binding.edPass.error = "Enter up to 6 character password!"
                binding.edPass.requestFocus()
                return false
            }
            else
            {
                binding.edPass.error = null
            }
        }
        return true
    }
}