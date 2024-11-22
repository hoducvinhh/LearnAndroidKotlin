package com.example.bai15

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai15.databinding.ActivityMainBinding

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
        //khai bao list danh sach cac bo phim
        var list = mutableListOf<OutData>()
        list.add(OutData(R.drawable.hinhanh, "Bang hoa ma tru"))
        list.add(OutData(R.drawable.hinhanh, "hoan hon "))
        list.add(OutData(R.drawable.hinhanh, "gia toc rong"))
        list.add(OutData(R.drawable.hinhanh, "than lan chi mong"))


        val customGV = CustomGridview(this, list)
        binding.gvPhim.adapter = customGV
    }
}