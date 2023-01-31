package com.example.login_register_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class SplashScreenActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var bottomnavbar:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//        navController = navHostFragment.navController
//       appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.HomeFrargment,R.id.BookFragment,R.id.CartFragment,
//               ),
//            drawerLayout = null
//        setupActionBarWithNavController(navController,appBarConfiguration)
//        bottomnavbar.setupWithNavController(navController)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return Navigation.findNavController(
//            this,
//            androidx.navigation.fragment.R.id.nav_host_fragment_container
//        ).navigateUp()
//    }

}