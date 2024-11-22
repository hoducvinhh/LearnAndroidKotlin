package com.example.bai8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai8.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addEvents()
    }

    private fun addEvents() {
        binding.radPic1.setOnCheckedChangeListener { compounButton, isChecked ->
            if (isChecked == true) {
                binding.imgHinhAnh.setImageResource(R.drawable.pic1)
            }
        }
        binding.radPic2.setOnCheckedChangeListener { compounButton, isChecked ->
            if (isChecked == true) {
                binding.imgHinhAnh.setImageResource(R.drawable.pic3)
            }
        }

        binding.btnThoat.setOnClickListener{
            finish()
        }
    }
}