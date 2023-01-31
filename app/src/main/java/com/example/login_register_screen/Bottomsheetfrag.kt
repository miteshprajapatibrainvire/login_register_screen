package com.example.login_register_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Bottomsheetfrag:BottomSheetDialogFragment() {

    lateinit var imgDownload:AppCompatImageView
    lateinit var imgUpload:AppCompatImageView
    lateinit var imgCamera:AppCompatImageView
    lateinit var imgShare:AppCompatImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.bottom_contain, container, false)

        imgDownload=view.findViewById(R.id.imgDownload)
        imgUpload=view.findViewById(R.id.imgUpload)
        imgCamera=view.findViewById(R.id.imgCamera)
        imgShare=view.findViewById(R.id.imgShare)

        imgDownload.setOnClickListener {
            Toast.makeText(context, "Image", Toast.LENGTH_SHORT).show()
        }

        imgUpload.setOnClickListener {
            Toast.makeText(context, "Upload", Toast.LENGTH_SHORT).show()
        }

        imgCamera.setOnClickListener {
            Toast.makeText(context, "Camera", Toast.LENGTH_SHORT).show()
        }

        imgShare.setOnClickListener {
            Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}