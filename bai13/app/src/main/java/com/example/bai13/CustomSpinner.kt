package com.example.bai13

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomSpinner(val activity: Activity, val list2: List<OutData>) :ArrayAdapter<OutData>(activity, R.layout.list_monan){
    override fun getCount(): Int {
        return list2.size // ve bao nhieu dong len spinner
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //position: Int vi tri cua mon an trong danh sach list
        //convertView: View che do xem cho tung muc trong spinner
        //parent: ViewGroup : Viewgroup cha dang chua spinner
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return initView(position, convertView, parent)
    }
    //ham xu ly view
    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val contexs = activity.layoutInflater
        //layoutInflater la 1 component
        // giup chuyen doi layout xml thanh view trong androi
        val rowView = contexs.inflate(R.layout.list_monan,parent, false)
        //dong lenh tren nay se bien xml thanh view

        val images = rowView.findViewById<ImageView>(R.id.images)
        val txtMonAn = rowView.findViewById<TextView>(R.id.txtMonAn)

        images.setImageResource(list2[position].image)
        txtMonAn.text = list2[position].misuta
        return rowView
    }
}