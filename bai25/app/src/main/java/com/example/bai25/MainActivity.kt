package com.example.bai25

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai25.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

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

        val adaptervv = ViewPagerAdapter(supportFragmentManager,lifecycle)
        binding.pagerTest.adapter = adaptervv
        TabLayoutMediator(binding.tabDeMo, binding.pagerTest)
        {
            tab, pos -> when(pos)
        {
                0->{tab.text= "Tab 1"}
                1->{tab.text= "Tab 2"}
                2->{tab.text= "Tab 3"}
                3->{tab.text= "Tab 4"}
                4->{tab.text= "Tab 5"}
            }
        }.attach()


    }
}