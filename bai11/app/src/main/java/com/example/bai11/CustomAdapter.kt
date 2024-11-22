package com.example.bai11

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(val activity: MainActivity, val list: List<OutData> ): ArrayAdapter<OutData> (activity, R.layout.list_item) {
    override fun getCount(): Int {
        return list.size // ve len view het tat ca cac dong cua list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = activity.layoutInflater
        // layoutInflater la 1 component giup chuyen doi layout xml thanh view trong androi
        val rowView = context.inflate(R.layout.list_item, parent, false)
        val images = rowView.findViewById<ImageView>(R.id.images)
        val title = rowView.findViewById<TextView>(R.id.title)
        val desc = rowView.findViewById<TextView>(R.id.desc)

        title.text = list[position].title
        desc.text = list[position].desc
        images.setImageResource(list[position].image)

        return rowView
    }
}