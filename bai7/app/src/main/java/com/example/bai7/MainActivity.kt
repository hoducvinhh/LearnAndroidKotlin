package com.example.bai7

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai7.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //khoi tao binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addEvent()



    }

    private fun addEvent() {
        //su ly su kien khi click vao nut chon so thich
        binding.btnChonSoThich.setOnClickListener {
            xuLyChonSoThich()

        }
        binding.btnXacNhan.setOnClickListener {
            xuLyXacNhan()
        }

    }

    private fun xuLyXacNhan() {
         var s:String = ""
        if(binding.radNam.isChecked)
        {
            s= binding.radNam.text.toString()
        }
        else if(binding.radNu.isChecked)
        {
            s = binding.radNu.text.toString()
        }

        if(s=="")
        {
            Toast.makeText(this, "Ban chua chon gioi tinh", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "Ban chon gioi tinh"+s, Toast.LENGTH_SHORT).show()
        }
    }

    private fun xuLyChonSoThich() {
        var s:String=""
        if(binding.chkNghenhac.isChecked)
            s+= binding.chkNghenhac.text.toString()+"\n"
        if(binding.chkXemPhim.isChecked)
            s+= binding.chkXemPhim.text.toString()+"\n"
        if(binding.chkChoiTheThao.isChecked)
            s+= binding.chkChoiTheThao.text.toString()+"\n"
        if(binding.chkShopping.isChecked)
            s+= binding.chkShopping.text.toString()+"\n"
        if(binding.chkDuLich.isChecked)
            s+= binding.chkDuLich.text.toString()+"\n"

        //gan vao o edtSoThich
        binding.edtSoThich.setText(s)
    }
}