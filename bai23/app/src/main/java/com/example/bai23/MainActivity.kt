package com.example.bai23

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bai23.databinding.ActivityMainBinding

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

            Xuly()
    }

    private fun Xuly() {
        var ds = mutableListOf<Int>()
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)
        ds.add(R.drawable.hinhanh)


        binding.rvView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val itemAdapter = RvAdapter(ds)
        binding.rvView.adapter = itemAdapter
    }
}