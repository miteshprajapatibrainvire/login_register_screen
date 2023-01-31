package com.example.login_register_screen

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.login_register_screen.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {


    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, Context.MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        binding.idImageBack.setOnClickListener {
            onBackPressed()
        }

        binding.btnSign.setOnClickListener {
                if(validation())
                {
                    val fullnameString=binding.edName.text
                    val emailString=binding.edEmail.text
                    val passwordString=binding.edConfirmPassword.text

                    myEdit.putString("fullName",fullnameString.toString())
                    myEdit.putString("email",emailString.toString())
                    myEdit.putString("password",passwordString.toString())
                    if(myEdit.commit())
                    {
                        Toast.makeText(this,"Registration successfully",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,LoginActivity::class.java))
                    }
                }
        }

        binding.txSingUp.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        val spannable =
            SpannableString("By singning you agree to our Team of use and privacy notice")

        val clickableSpan1: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                passIntentPrivacyPolicy()
            }
        }

        spannable.setSpan(clickableSpan1, 0,28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#2D6332")),
            0,
            28,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.txBottomData.setText(spannable, TextView.BufferType.SPANNABLE)
        binding.txBottomData.setMovementMethod(LinkMovementMethod.getInstance())

        val clickableSpan2: ClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                passIntentPrivacyPolicy()
            }
        }

        spannable.setSpan(clickableSpan2, 40,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#2D6332")),
            40,
            44,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.txBottomData.setText(spannable, TextView.BufferType.SPANNABLE)
        binding.txBottomData.setMovementMethod(LinkMovementMethod.getInstance())

    }

    private fun validation():Boolean{

            if (binding.edName.text!!.isEmpty()) {
                binding.edName.error = "Enter Full Name!"
                binding.edName.requestFocus()
                return false
            } else {
                binding.edName.error = null
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
                                        binding.edPassword2.error = "Password and Confirm password both should be match!"
                                        return false
                                    }
                                    else
                                    {
                                        binding.edPassword2.error=null
                                        binding.edConfirmPassword.error=null
                                        if(!binding.checkBox.isChecked)
                                        {
                                            Toast.makeText(this, "Please check Agreement? ", Toast.LENGTH_SHORT).show()
                                            return false
                                        }
                                        else
                                        {
                                            binding.checkBox.error=null
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
        return true
    }

    fun passIntentPrivacyPolicy()
    {
        startActivity(Intent(this,PrivacyPolicyActivity::class.java))
    }
}