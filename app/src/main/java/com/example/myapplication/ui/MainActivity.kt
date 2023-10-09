package com.example.myapplication.ui


import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R


class MainActivity : AppCompatActivity() , LocationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         gotomenu()

        // sendNotification("0","Registro De Ubicacion","Se ha registrado nueva ubicacion")

    }



    fun gotomenu(){
        // Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
        // }, 2000)

    }



    private lateinit var locationManager: LocationManager
    // private lateinit var tvGpsLocation: TextView
    private val locationPermissionCode = 2

    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        /* if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this) */
    }

    override fun onLocationChanged(location: Location) {
        // tvGpsLocation = findViewById(R.id.textView)
        // tvGpsLocation.text = "Latitude: " + location.latitude + " , Longitude: " + location.longitude
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                // Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }








}