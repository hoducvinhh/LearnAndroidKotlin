package com.example.bai22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(var ds:List<OutData>,val onPhimClick: RvInterface) :RecyclerView.Adapter<RvAdapter.PhimViewHolder>(){
    //class viewholder
    inner class PhimViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhimViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return PhimViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhimViewHolder, position: Int) {
       holder.itemView.apply {
           val txtMieuTa = findViewById<TextView>(R.id.txtMieuTa)
           txtMieuTa.text = ds[position].mieuTa
           val txtTenPhim = findViewById<TextView>(R.id.txtTenPhim)
           txtTenPhim.text = ds[position].tenPhim
           val imgPhim = findViewById<ImageView>(R.id.imgPhim)
           imgPhim.setImageResource(ds[position].image)

           //lang nghe Item click chon
           holder.itemView.setOnClickListener{
               onPhimClick.OnClickPhim(position)
           }
       }
    }

    override fun getItemCount(): Int {
        return ds.size
    }

}

