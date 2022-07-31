package com.huda.furnituretask.presentation

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.NavigationUI
import com.google.gson.GsonBuilder
import com.huda.furnituretask.R
import com.huda.furnituretask.databinding.ActivityMainBinding
import com.huda.furnituretask.interfaces.NavigationBarVisibilityListener
import com.huda.furnituretask.network.AuthService
import com.huda.furnituretask.network.FurnitureService
import com.huda.furnituretask.network.model.CustomerDto
import com.huda.furnituretask.network.model.LoginInformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity(), NavigationBarVisibilityListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://backend.forhomi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

        val authService = retrofit
            .create(AuthService::class.java)
        val furnitureService = retrofit
            .create(FurnitureService::class.java)

        CoroutineScope(IO).launch {
            val authResponse = authService.register(
                CustomerDto(
                    "huda",
                    "huda.anwar94@gmail.com",
                    "01025387616",
                    "123456",
                    "123456",
                    "en",
                    "qwrd",
                    "",
                    "+20",
                    "1994-04-30",
                    "Female",
                    "28",
                    0,
                    0,
                    ""
                )
            )
            val loginResponse= authService.login(LoginInformation("somaya@gmail.com","123456"))
            val homeResponse = furnitureService.getHome()
            Log.d("HomeService", "onCreate: ${homeResponse.body()?.data?.categories}")

            Log.d(
                "MainActivity2", "onCreate: ${
                    loginResponse.body()
                } "
            )
        }
    }

    override fun navbarVisibility(isVisible: Int) {
        binding.bottomNavigation.visibility = isVisible
        binding.bottomNavigation.itemIconTintList = null
    }

    override fun navGraphVisibility(isVisible: Int) {

    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}