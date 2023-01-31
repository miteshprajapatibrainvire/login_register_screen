package com.example.login_register_screen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.login_register_screen.databinding.ActivityMainBinding
import com.example.login_register_screen.databinding.ActivityUpdateBinding

class UpdateProfileActivity : AppCompatActivity() {


    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    lateinit var email:String
    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.hide()

        binding.idImageBack.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }

        val sharePref=getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)

        if (sharePref.getString(
                "email", null
            ) != null && sharePref.getString("password", null) != null
        ) {
            email = sharePref.getString("email", null)!!
            binding.edEmail.setText(email.toString())
        }

        val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, Context.MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        binding.btnUpdate.setOnClickListener {
            if(validation())
            {
                myEdit.putString("email",binding.edEmail.text.toString())
                myEdit.putString("password",binding.edConfirmPassword.text.toString())
                if(myEdit.commit())
                {
                    Toast.makeText(this,"Record Update successfully", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,HomeActivity::class.java))
                }
            }
        }
    }

    private fun validation():Boolean{

            if(binding.edEmail.text!!.isEmpty())
            {
                binding.edEmail.error = "Enter Email!"
                binding.edEmail.requestFocus()
                return false
            }
            else
            {
                if (!binding.edEmail.text.toString().trim().matches(emailPattern.toRegex()))
                {
                    binding.edEmail.error = "Invalid Email Address!"
                    binding.edEmail.requestFocus()
                    return false
                }
                else
                {
                    binding.edEmail.setBackgroundResource(R.drawable.valid_ring)
                    binding.edEmail.error = null
                    if (binding.edPassword2.text!!.isEmpty()) {
                        binding.edPassword2.error = "Enter Password!"
                        binding.edPassword2.requestFocus()
                        return false
                    } else {
                        binding.edPassword2.error = null
                        if(binding.edPassword2.length()<6)
                        {
                            binding.edPassword2.error = "Enter up to 6 character password!"
                            binding.edPassword2.requestFocus()
                            return false
                        }
                        else
                        {
                            binding.edPassword2.error = null
                            if (binding.edConfirmPassword.text!!.isEmpty()) {
                                binding.edConfirmPassword.error = "Enter Password!"
                                binding.edConfirmPassword.requestFocus()
                                return false
                            } else {
                                binding.edConfirmPassword.error = null
                                if(binding.edConfirmPassword.length()<6)
                                {
                                    binding.edConfirmPassword.error = "Enter up to 6 character password!"
                                    binding.edConfirmPassword.requestFocus()
                                    return false
                                }
                                else
                                {
                                    binding.edConfirmPassword.error = null
                                }

                                if(!binding.edPassword2.text.toString().equals(binding.edConfirmPassword.text.toString()))
                                {
                                    binding.edPassword2.error = "Password and Confirm password should be match!"
                                    binding.edConfirmPassword.error = "Password and Confirm password both should be match!"
                                    return false
                                }
                                else
                                {
                                    binding.edPassword2.error=null
                                    binding.edConfirmPassword.error=null
                                }
                            }
                        }
                    }
                }
            }
        return true
    }
}