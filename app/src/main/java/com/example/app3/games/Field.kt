package com.example.app3.games

import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.app3.R

class Field (parent: RelativeLayout, private val size: Int,private val cx:Int,private val cy:Int){
    private val cells = ArrayList<ImageView>()
    private var coordinats=arrayOf<Array<Point>>()
    init {
        for (i in 0 until size) {
            var array = arrayOf<Int>()
            for (j in 0 until size) {
                array += 0
            }
            coordinats += array
        }

        for (i in (0..coordinats.size-2 step 2)) {
            val img = ImageView(parent.context)
            cells.add(img)
            img.setImageResource(R.drawable.field)

            val params = RelativeLayout.LayoutParams(50, 50)
            params.leftMargin = coordinats[i]
            params.topMargin = coordinats[i + 1]
            //img.layoutParams = params // второй вариант

            parent.addView(img, params) // parent.addView(img) // второй вариант

        }
    }





}