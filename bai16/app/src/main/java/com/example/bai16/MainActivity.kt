package com.example.bai16

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai16.databinding.ActivityMainBinding

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


        //khai bao bien today get ngay thang hien tai
        val today = Calendar.getInstance()

        val starHour = today.get(Calendar.HOUR_OF_DAY)
        val starMinute = today.get(Calendar.MINUTE)

        //set thoi gian khi click vao button time
        //langw nghe click ken button time
        binding.btnTime.setOnClickListener {
            //timePicker
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                //i: gio khi nguoi dung chon
                //i2:  phut
                binding.txtTime.setText("$i:$i2")
            },starHour,starMinute,true).show()
        }
        
        //datepicker
        //langnghe click len button btndate
        binding.btnDate.setOnClickListener { 
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                //i: nam
                //i2: thang
                //I3 :ngay
                binding.txtDate.setText("$i3/${i2+1}/$i")
            },2007,7,7).show()
        }
    }
}