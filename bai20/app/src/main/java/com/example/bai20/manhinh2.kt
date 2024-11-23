package com.example.bai20

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai20.databinding.ActivityMainBinding
import com.example.bai20.databinding.ActivityManhinh2Binding

private lateinit var binding: ActivityManhinh2Binding
class manhinh2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManhinh2Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //get du lieu tu bundle
        val i = intent
        //lay bundle ra khoi intent
        val bundle = i.extras
        if(bundle != null)
        {
            val bienStringss = bundle.getString("bienString")
            val bienDouble = bundle.getDouble("bienDouble")
            val bienbool = bundle.getBoolean("bienbool")
            val bienInt = bundle.getInt("bienInt")


            binding.edtGetIntent.setText(bienStringss+"\n"+bienInt+"\n"+bienDouble+"\n"+bienbool)
        }


//        //get du lieu tu main
//        val i = intent
//        val bienStringsss = i.getStringExtra("bienString")
//        val bienDouble = i.getDoubleExtra("bienDouble",0.0)
//        val bienBool = i.getBooleanExtra("bienbool",false)
//        binding.edtGetIntent.setText(bienStringsss+"\n"+bienBool+"\n"+bienDouble)

        // goi lenh quay tro lai man hinh main
        binding.btnback.setOnClickListener{
            val i3 = Intent(this, manhinh3::class.java)
            startActivity(i3)
        }
    }
}