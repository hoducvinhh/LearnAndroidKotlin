package com.example.bai14

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.bai14.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //khai bao list danh sach tinh thanh
        val list = resources.getStringArray(R.array.tinhthanh)
        val adt = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, list
            )

        binding.autoTinhThanh.setAdapter(adt)

        //goi y voi 0 ki tu nhap vao

        binding.autoTinhThanh.setOnFocusChangeListener( { v, hasFocus -> if(hasFocus) binding.autoTinhThanh.showDropDown()  })

        //kiem tra xem item nao duoc chon
        binding.autoTinhThanh.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Click item "+ binding.autoTinhThanh.text.toString(),Toast.LENGTH_SHORT).show()
        })
    }
}