package com.example.bai20

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai20.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
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

        //goi man hinh 2 tu man hinh man
        binding.btngo.setOnClickListener {
            val intent1 = Intent(this, manhinh2::class.java)

            //truyen du lieu bang bundle
            //1.nap du lieu
            val bundle = Bundle()
            bundle.putString("bienString","chao mung den voi tuhoc.cc")
            bundle.putDouble("bienDouble",123.45)
            bundle.putBoolean("bienbool",true)
            bundle.putInt("bienInt",78)

            //dat bundle vao trong intent
            intent1.putExtras(bundle)




            //truyen du lieu truc tiep bang Intent
//            intent1.putExtra("bienString","chao mung den voi tuhoc.cc")
//            intent1.putExtra("bienDouble",123.45)
//            intent1.putExtra("bienbool",true)

            startActivity(intent1)
        }

        //goi url tu man hinh main
        binding.btngo2.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("http://tuhoc.cc"))
            startActivity(intent2)
        }
    }
}