package com.example.bai27

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai27.databinding.ActivityMainBinding
import com.example.bai27.databinding.CustomDialogBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnClick.setOnClickListener {
            showDialogNomal()
        }

//        binding.btnClick.setOnClickListener {
//            showDialogBinding()
//        }

    }

//    private fun showDialogBinding() {
//        val build = AlertDialog.Builder(this)
//        val dialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(this))
//        build.setView(dialogBinding.root)
//        dialog = build.create()
//        dialog.show()
//    }
    private fun showDialogNomal() {
        val build = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.custom_dialog,null)
        build.setView(view)
        dialog = build.create()
        dialog.show()
    }
}