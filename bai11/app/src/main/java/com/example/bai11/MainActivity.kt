package com.example.bai11

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.pic1, "gia toc rong", "day la mieu ta cua gia toc rong"))
        list.add(OutData(R.drawable.pic2, "hoan hon", "day la mieu ta cua hoan hon"))
        list.add(OutData(R.drawable.pic1, "than lan vo song", "day la mieu ta cua than lan vo song"))
        list.add(OutData(R.drawable.pic2, "bang hoa ma tru", "day la mieu ta cua bang hoa ma tru"))

        customAdapter = CustomAdapter(this, list)
        // khai vao 1 bien de linh den lvPhim
        val lvPhim = findViewById<ListView>(R.id.lvPhim)
        lvPhim.adapter = customAdapter
    }
}