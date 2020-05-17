package com.app1.textandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CourseAdapter(context: Context, data:ArrayList<CustomItemClass>):ArrayAdapter<CustomItemClass>(context, 0,data){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView:View?
        itemView = LayoutInflater.from(context).inflate(R.layout.item,parent, false)

        val itemData = getItem(position)

        val title = itemView.findViewById<TextView>(R.id.course_title)
        val price = itemView.findViewById<TextView>(R.id.course_price)
        val image = itemView.findViewById<ImageView>(R.id.course_image)

        title.text = itemData?.title
        price.text = itemData?.price
        image.setImageResource(itemData?.image!!)


        return itemView

    }
}