package com.app1.textandroid

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayData()
    }

    fun displayData(){
        val courses = ArrayList<CustomItemClass>()
        courses.add(CustomItemClass(R.drawable.animation1, "Android Development", "20$"))
        courses.add(CustomItemClass(R.drawable.animation2, "Android Development", "20$"))
        courses.add(CustomItemClass(R.drawable.animation3, "Android Development", "20$"))
        val adapter = CourseAdapter(this@MainActivity, courses)

        list.adapter = adapter
        
        list.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->

            val alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.course_alert)

            val title = alert.findViewById<TextView>(R.id.alert_title)
            val price = alert.findViewById<TextView>(R.id.alert_price)
            val image = alert.findViewById<ImageView>(R.id.alert_image)
            val close = alert.findViewById<Button>(R.id.alert_close)

            val itemData = adapter.getItem(position)
            title.text = itemData?.title
            price.text = itemData?.price
            image.setImageResource(itemData?.image!!)

            alert.show()

            close.setOnClickListener{
                alert.hide()
            }
        }


    }
}
