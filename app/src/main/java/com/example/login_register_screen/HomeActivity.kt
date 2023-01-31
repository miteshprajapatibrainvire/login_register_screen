package com.example.login_register_screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.login_register_screen.databinding.ActivityHomeBinding
import com.example.login_register_screen.fragmentsbottom.HomeFragment
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener


class HomeActivity : AppCompatActivity(),OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        setContentView(binding.root)
        supportActionBar?.hide()

//        registerForContextMenu(binding.floatBtnId)
        registerForContextMenu(binding.floatBtnId)
//        binding.floatBtnId.setOnClickListener{
//            Toast.makeText(this, "float button", Toast.LENGTH_SHORT).show()
//        }

        val fullName:String= intent.getStringExtra("fullname").toString()
        val pass:String= intent.getStringExtra("password").toString()
        val email:String=intent.getStringExtra("emailString").toString()
        Log.e("fullname",fullName)
        Log.e("pass",pass)
        Log.e("email",email)
        val bundle=Bundle()
        bundle.putString("password",pass)
        bundle.putString("email",email)
        val homeFrame=HomeFragment()
        homeFrame.arguments=bundle
//        supportFragmentManager.beginTransaction().replace(R.id.container,homeFrame).commit()

        //bottomnavbar=findViewById(R.id.bottomNavBar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerViewid) as NavHostFragment
        navController = navHostFragment.navController

        drawerLayout=binding.drawerlayout

        NavigationUI.setupWithNavController(binding.navView,navController)
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.bookFragment,R.id.cartFragment,
            ),
            drawerLayout = null)
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNavBar.setupWithNavController(navController)
        binding.navView.setNavigationItemSelectedListener(this)

/*
        val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)

        val arrArg=ArrayList<ImageModel>()
        arrArg.add(ImageModel(R.drawable.waterbeach,"water",null))
        arrArg.add(ImageModel(R.drawable.riverhill,"river",null))
        arrArg.add(ImageModel(R.drawable.sunsetrose,"sunset",null))

        adpList.add(ImageModel(R.drawable.imgmountain,"Mountain",arrArg))
        adpList.add(ImageModel(R.drawable.moonstar,"Moonstart",arrArg))
        adpList.add(ImageModel(R.drawable.imgbaloon,"Baloon",arrArg))
        val adpRecy= Adapter(this, adpList)
        binding.recyId.adapter=adpRecy
        binding.recyId.layoutManager=LinearLayoutManager(this)

        setSupportActionBar(binding.toolbar)

        val textList = ArrayList<String>()
        textList.add("Slide 1 Maountain")
        textList.add("Slide 2 Balloon")
        textList.add("Slide 3 Star")

        val imgList=ArrayList<Int>()
        imgList.add(R.drawable.imgmountain)
        imgList.add(R.drawable.imgbaloon)
        imgList.add(R.drawable.moonstar)
        imgList.add(R.drawable.riverhill)
        imgList.add(R.drawable.waterbeach)
        imgList.add(R.drawable.mothernature)
        mViewPagerAdapter = ImageAdapter(this, textList,imgList)
        binding.viewpager.adapter = mViewPagerAdapter

        val handler = Handler()
        val Update = Runnable {
            if (currentPage === imgList.size ) {
                currentPage = 0
            }
            binding.viewpager.setCurrentItem(currentPage++, true)
        }
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_TIME, PERIOD_TIME)

        val fullName:String= intent.getStringExtra("fullname").toString()
        val pass:String= intent.getStringExtra("password").toString()
        val email:String=intent.getStringExtra("email").toString()

        if(intent!=null)
        {
            binding.txName.text = "Your name = $fullName"
            binding.txPassword.text = "Your Password = $pass"
            binding.txEmail.text = "your Email = $email"
        }

        registerForContextMenu(binding.txName)
        registerForContextMenu( binding.txPassword)
        registerForContextMenu( binding.txEmail)

        if(sharedPreferences.getString("fullName",null)!=null && sharedPreferences.getString("password",null)!=null)
        {
            binding.txName.setText("name = "+sharedPreferences.getString("fullName",null))
            binding.txPassword.text = "Password = ${sharedPreferences.getString("password", null)!!}"
            binding.txEmail.text ="Email = "+sharedPreferences.getString("email",null)!!
        }
*/
//        binding.bottomNav.setOnNavigationItemSelectedListener {
//            when(it.itemId)
//            {
//                R.id.idHomeIcon->{
//                    supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragment()).commit()
//                }
//                R.id.idCartIcon->{
//                    supportFragmentManager.beginTransaction().replace(R.id.container,CartFragment()).commit()
//                }
//                R.id.idbook->{
//                    supportFragmentManager.beginTransaction().replace(R.id.container,BookFragment()).commit()
//                }
//            }
//             true
//        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_directory, menu)
        menu!!.setHeaderTitle("Select The Action")
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(
            this,
            androidx.navigation.fragment.R.id.nav_host_fragment_container
        ).navigateUp()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.idTabLayout->{
                startActivity(Intent(this,TabLayoutActivity::class.java))
            }
            R.id.idUpdateProfile->{
                startActivity(Intent(this,UpdateProfileActivity::class.java))
            }
            R.id.idLogout->{
                val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)
                val edit=sharedPreferences.edit()
                edit.putBoolean("checkRemember",false)
                edit.commit()
                startActivity(Intent(this,MainActivity::class.java))
            }
            R.id.idBottomSheet->{
                val bottomFrag = Bottomsheetfrag()
                bottomFrag.show(supportFragmentManager, "Bottom Fragment")
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_directory, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.idTabLayout->{
               startActivity(Intent(this,TabLayoutActivity::class.java))
            }
            R.id.idUpdateProfile->{
                startActivity(Intent(this,UpdateProfileActivity::class.java))
            }
            R.id.idLogout->{
                val sharedPreferences=getSharedPreferences(MainActivity.sharedPreferenceData, MODE_PRIVATE)
                val edit=sharedPreferences.edit()
                edit.putBoolean("checkRemember",false)
                edit.commit()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.homeFragment->{
                drawerLayout.closeDrawer(GravityCompat.START)
                navController.navigate(R.id.action_cartFragment_to_homeFragment)
            }

            R.id.cartFragment->{
                drawerLayout.closeDrawer(GravityCompat.START)
                navController.navigate(R.id.action_bookFragment_to_cartFragment)
            }

            R.id.bookFragment->{
                drawerLayout.closeDrawer(GravityCompat.START)
                navController.navigate(R.id.action_homeFragment_to_bookFragment)
            }

        }
        return NavigationUI.onNavDestinationSelected(item,navController)
    }

}