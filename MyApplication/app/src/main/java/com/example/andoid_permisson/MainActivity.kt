package com.example.andoid_permisson

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val M_requestCode: Int = 1803

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkPermission();
    }

    private fun checkPermission() {

        var listPermissionNeeded: ArrayList<String> = ArrayList()
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_DENIED){
                listPermissionNeeded.add( android.Manifest.permission.INTERNET)
        }
    }
}