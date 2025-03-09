package com.example.bai26

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai26.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
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

        binding.btnExit.setOnClickListener {
            val dialog = AlertDialog.Builder(this )
            dialog.apply {
                // tieu de cua hop thoai thong bao
                setTitle("Confirm Window")
                // noi dung thong bao
                setMessage("Do you want to close this app")
                //nut phu dinh
                setNegativeButton("No"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                //nut khang dinh
                setPositiveButton("Yes"){ dialogInterface: DialogInterface, i: Int ->
                   finish()
                }
            }

            dialog.show()
        }
    }
}