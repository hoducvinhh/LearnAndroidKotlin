package com.example.bai9

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai9.databinding.ActivityMainBinding


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

        //test thu chuyen mau cho list view
//        val mauxanh = Color.parseColor("#99FFFFF")
//        binding.lvQuocGia.setBackgroundColor(mauxanh)

        //khai bao arrQuocGia su dung resourses de lay thong tin tu string.xml
//        var arrQuocGia = resources.getStringArray(R.array.arrQuocGia)
//        //gan nguon cho adapter de hien thi len lv
//        binding.lvQuocGia.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrQuocGia )
        addevent()
    }

    private fun addevent() {
        hienthilvQuocGia()
    }

    private fun hienthilvQuocGia() {
        var arrQuocGia = resources.getStringArray(R.array.arrQuocGia)
        //gan nguon cho adapter de hien thi len lv
        binding.lvQuocGia.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrQuocGia )

        binding.lvQuocGia.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Ban chon"+ arrQuocGia[i], Toast.LENGTH_SHORT).show()
        }
    }
}