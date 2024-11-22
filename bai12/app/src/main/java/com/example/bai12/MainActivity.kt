package com.example.bai12

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai12.databinding.ActivityMainBinding

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

        //ham test spinner co ban
        setupSpinnerCoBan()
    }

    private fun setupSpinnerCoBan() {
        //var list = resources.getStringArray(R.array.ngonngu)
        val list = mutableListOf<String>()
        list.add("English")
        list.add("Viet Nam")
        list.add("Tay ban nha")
        list.add("English")
        //khai bao bo dieu huong
        val adt = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        //goi soinner
        binding.spNgonNgu.adapter = adt

        //onItemSelectedListenner
        binding.spNgonNgu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity , "Ban chon"+ list[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }}
}