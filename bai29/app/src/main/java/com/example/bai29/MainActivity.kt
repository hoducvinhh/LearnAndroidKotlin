package com.example.bai29

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai29.databinding.ActivityMainBinding

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
        //dang ki menu ngu canh
        registerForContextMenu(binding.txtContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1,1,1,"Red")
        menu?.add(1,2,2,"Green")
        menu?.add(1,3,3,"Black")

        //submenu
        var submenu = menu?.addSubMenu("Gioi tinh")
        submenu?.add(2,21,1,"Male")?.setChecked(true)
        submenu?.add(2,22,2,"FeMale")
        submenu?.setGroupCheckable(2,true,true)
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{ binding.txtOption.setTextColor(Color.RED)}
            2->{ binding.txtOption.setTextColor(Color.GREEN)}
            3->{ binding.txtOption.setTextColor(Color.BLACK)}
            //tuong ta voi submenu
            21->{ binding.txtOption.setText("Male")}
            22->{ binding.txtOption.setText("FeMale")}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(3,31,1,"Red")
        menu?.add(3,32,2,"Green")
        menu?.add(3,33,3,"Black")
        menu?.setHeaderTitle("Moi cu chon mau")
    }

    //xu ly su kien contextmenu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            31->{ binding.txtContext.setTextColor(Color.RED)}
            32->{ binding.txtContext.setTextColor(Color.GREEN)}
            33->{ binding.txtContext.setTextColor(Color.BLACK)}
        }
        return super.onContextItemSelected(item)
    }


}