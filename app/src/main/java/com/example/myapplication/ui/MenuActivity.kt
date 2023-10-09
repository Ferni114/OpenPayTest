package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
         setupActionBarWithNavController(navController, appBarConfiguration)
        // navView.setupWithNavController(navController) */

        replaceFragment(ProfileFragment())
        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {  replaceFragment(ProfileFragment())
                    true
                }
                R.id.movies -> {replaceFragment(MoviesFragment())
                    true
                }
                R.id.maps -> {replaceFragment(MapsFragment())
                    true
                }
                R.id.files -> {replaceFragment(UploadFilesFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private  fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}