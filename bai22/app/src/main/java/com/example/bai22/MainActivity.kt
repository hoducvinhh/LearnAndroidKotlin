package com.example.bai22

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai22.RvInterface
import com.example.bai22.databinding.ActivityMainBinding
import com.example.bai22.RvInterface as RvInterface1

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

        //tao ra ds
        val ds = mutableListOf<OutData>()
                ds.add(OutData(R.drawable.hinhanh,"Bang hoa ma tru","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Hoan hon","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))
                ds.add(OutData(R.drawable.hinhanh,"Rong gia toc","Phim trung quoc"))

        val adapterr = RvAdapter(ds, object : RvInterface{
            override fun OnClickPhim(pos: Int) {
                Toast.makeText(this@MainActivity, "Ban da click vao ${ds[pos].tenPhim}",Toast.LENGTH_SHORT).show()
            }

        })

        binding.rvDEmo.adapter = adapterr
        binding.rvDEmo.layoutManager = LinearLayoutManager(
            this,LinearLayoutManager.HORIZONTAL, false
        )
    }
}