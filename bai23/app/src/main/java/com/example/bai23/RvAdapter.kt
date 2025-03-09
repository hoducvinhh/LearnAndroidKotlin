package com.example.bai23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter (private var ds:List<Int>):RecyclerView.Adapter<RvAdapter.itemViewHolder>(){
    class itemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return itemViewHolder((view))
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.itemView.apply {
            val img = findViewById<ImageView>(R.id.imgAnh)
            img.setImageResource(ds[position])
        }
    }

    override fun getItemCount(): Int {
        return ds.size;
    }
}