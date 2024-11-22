package com.example.bai5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtNhapA = findViewById<EditText>(R.id.edtNhapA)
        val edtNhapB = findViewById<EditText>(R.id.edtNhapB)
        val edtKq = findViewById<EditText>(R.id.edtKq)
        val btnCOng = findViewById<Button>(R.id.btnCong)
        val btnReset = findViewById<Button>(R.id.btnReset)

        //set text cho edtNhapA
        //edtNhapA.setText("o la la")

        btnCOng.setOnClickListener {
            val A= edtNhapA.text.toString().toInt()
            val B= edtNhapB.text.toString().toInt()
            val kq = A + B
            edtKq.setText(kq.toString())
        }

        btnReset.setOnClickListener {
            edtNhapA.setText("")
            edtNhapB.setText("")
            edtKq.setText("")
            //Thong bao nhanh tren man hinh
            Toast.makeText(this, "Em da xoa het roi nhe", Toast.LENGTH_SHORT).show()
        }
    }
}