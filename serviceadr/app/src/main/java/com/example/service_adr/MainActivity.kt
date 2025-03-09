package com.example.service_adr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var serviceCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            Intent(this, MyService::class.java).also {
                intent.putExtra(MyService.EXTRA_SERVICE_COUNTER, serviceCounter++)
                startService(intent)
            }
        }
    }
}