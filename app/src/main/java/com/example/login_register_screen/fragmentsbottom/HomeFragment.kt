package com.example.login_register_screen.fragmentsbottom

import android.content.Context.MODE_PRIVATE
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.login_register_screen.MainActivity
import com.example.login_register_screen.R
import com.example.login_register_screen.adapters.Adapter
import com.example.login_register_screen.adapters.ImageAdapter
import com.example.login_register_screen.models.ImageModel
import com.example.login_register_screen.models.ViewModelData
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class HomeFragment : Fragment() {

    lateinit var mViewPagerAdapter: ImageAdapter
    var adpList= java.util.ArrayList<ImageModel>()
    var currentPage = 0
    var timer: Timer? = null
    val DELAY_TIME: Long = 500
    val PERIOD_TIME: Long = 3000
    var recy:RecyclerView?=null
    var txemail:TextView?=null
    var txpass:TextView?=null
    var txfullname:TextView?=null
    var fullname:String?=null
    var pass:String?=null
    var email:String?=null
    var viewpager:ViewPager?=null
    var hashmap:HashMap<Int,String>?=null
    var arrModel:ArrayList<ViewModelData>?=null
    lateinit var tablayout:TabLayout
    lateinit var chip:Chip
    lateinit var chip2:Chip
    lateinit var chipGroup:ChipGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_first, container, false)

         chip=view.findViewById(R.id.chipt)
        chip2=view.findViewById(R.id.chip2)
        chipGroup=view.findViewById(R.id.chipgroup)
        chipGroup.forEach { child ->
            (child as? Chip)?.setOnCheckedChangeListener { _, _ ->
                registerFilterChanged()
            }
        }

        chip.setOnCloseIconClickListener {
            chip.visibility=View.GONE
        }

        chip2.setOnClickListener {
            chip2.isCheckable=true
            chip2.chipBackgroundColor=ColorStateList.valueOf(resources.getColor(R.color.blue))
        }

         pass=arguments?.getString("password",null)
         email=arguments?.getString("email",null)

        Log.e("fragment fullname",email.toString())
        Log.e("fragment pass",pass.toString())

        initView(view)
        storeSession()

        val share=requireActivity().getSharedPreferences("storeSession", MODE_PRIVATE)
        if (share.getString(
                "email", null
            ) != null && share.getString("pass", null) != null
        ) {
            Log.e("get sessiondata=",share.getString("email", null).toString())
            txpass?.text=share.getString("pass", null)
        }

        val sharedPreferences=requireActivity().getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)

        val arrArg=ArrayList<ImageModel>()
        arrArg.add(ImageModel(R.drawable.waterbeach,"water",null))
        arrArg.add(ImageModel(R.drawable.riverhill,"river",null))
        arrArg.add(ImageModel(R.drawable.sunsetrose,"sunset",null))

        adpList.add(ImageModel(R.drawable.imgmountain,"Mountain",arrArg))
        adpList.add(ImageModel(R.drawable.moonstar,"Moonstart",arrArg))
        adpList.add(ImageModel(R.drawable.imgbaloon,"Baloon",arrArg))
        val adpRecy= Adapter(requireContext(), adpList)
        recy?.adapter=adpRecy
        recy?.layoutManager= LinearLayoutManager(requireContext())

//        val textList = ArrayList<String>()
//        textList.add("Slide 1 Maountain")
//        textList.add("Slide 2 Balloon")
//        textList.add("Slide 3 Star")
//
//        val imgList=ArrayList<Int>()
//        imgList.add(R.drawable.imgmountain)
//        imgList.add(R.drawable.imgbaloon)
//        imgList.add(R.drawable.moonstar)

        arrModel=ArrayList()
        arrModel?.add(ViewModelData(R.drawable.imgmountain,"Slide 1 Maountain"))
        arrModel?.add(ViewModelData(R.drawable.imgbaloon,"Slide 2 Balloon"))
        arrModel?.add(ViewModelData(R.drawable.moonstar,"Slide 3 Star"))

        mViewPagerAdapter = ImageAdapter(requireContext(), arrModel!!)
        viewpager?.adapter = mViewPagerAdapter
        tablayout.setupWithViewPager(viewpager, true)

//        val handler = Handler()
//        val Update = Runnable {
//            if (currentPage === arrModel!!.size ) {
//                currentPage = 0
//            }
//            viewpager?.setCurrentItem(currentPage++, true)
//        }
//        timer = Timer()
//        timer!!.schedule(object : TimerTask() {
//            override fun run() {
//                handler.post(Update)
//            }
//        }, DELAY_TIME, PERIOD_TIME)

//        val fullName:String= intent.getStringExtra("fullname").toString()
//        val pass:String= intent.getStringExtra("password").toString()
//        val email:String=intent.getStringExtra("email").toString()
//        if(intent!=null)
//        {
//            binding.txName.text = "Your name = $fullName"
//            binding.txPassword.text = "Your Password = $pass"
//            binding.txEmail.text = "your Email = $email"
//        }
//        registerForContextMenu(binding.txName)
//        registerForContextMenu( binding.txPassword)
//        registerForContextMenu( binding.txEmail)
//        if(sharedPreferences.getString("fullName",null)!=null && sharedPreferences.getString("password",null)!=null)
//        {
//            binding.txName.setText("name = "+sharedPreferences.getString("fullName",null))
//            binding.txPassword.text = "Password = ${sharedPreferences.getString("password", null)!!}"
//            binding.txEmail.text ="Email = "+sharedPreferences.getString("email",null)!!
//        }

        return view
    }

    private fun storeSession()
    {
        val share=requireActivity().getSharedPreferences("storeSession", MODE_PRIVATE)
        if (share.getString(
                "email", null
            ) == null && share.getString("pass", null) == null
        ) {
            val edit = share.edit()
            edit.putString("email", email.toString())
            edit.putString("pass", pass.toString())
            edit.commit()
         }
    }

    private fun initView(view: View?) {
        recy=view?.findViewById(R.id.recyId)
        viewpager=view?.findViewById(R.id.viewpager)
        txfullname=view?.findViewById(R.id.txName)
        txpass=view?.findViewById(R.id.txPassword)
        tablayout= view?.findViewById<TabLayout>(R.id.tablay)!!
    }

    private fun registerFilterChanged() {


    }

}