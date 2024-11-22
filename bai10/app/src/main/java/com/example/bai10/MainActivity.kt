package com.example.bai10

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai10.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var ds:MutableList<String> = mutableListOf("012345678","01238458498")
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
    //hien thi ds ban dau
        binding.lvTen.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ds)

        addevent()

    }

    private fun addevent() {
        // code cho button luu
        binding.btnLuu.setOnClickListener {
            hamXuLyNutLUu()

        }
    }

    private fun hamXuLyNutLUu() {
        var s:String = binding.edtTen.text.toString()
        ds.add(s) // them sdt vao list ds
        binding.edtTen.setText("")
        binding.edtTen.requestFocus() // day con tro van baan vao o nhap lieu
        binding.lvTen.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ds)
    }
}