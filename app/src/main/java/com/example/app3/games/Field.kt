package com.example.app3.games

import android.util.Log
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.app3.R
import com.example.app3.constance.Constance
import kotlin.random.Random

class Field(
    parent: RelativeLayout,
    private val size: Int,
    private val cx: Int,
    private val cy: Int
) {
    private val cells = ArrayList<ImageView>()
    private var coordinats = arrayListOf<Point>()
    private var detective_coordinats= arrayListOf<Point>()

    init {


        coordinats.add(Point(cx, cy))
        for (index in 0 until size-1) {
            val pool = arrayListOf<Point>()
            for (point in coordinats) {
                if (Point(point.x+Constance.SIZE_IMG_FOR_GAMES,point.y).inArray(coordinats)&&Point(point.x+Constance.SIZE_IMG_FOR_GAMES,point.y).inDekstope(cx,cy)) {
                    var temp= Point(point.x+Constance.SIZE_IMG_FOR_GAMES,point.y)
                    pool.add(temp)
                }
                if (Point(point.x-Constance.SIZE_IMG_FOR_GAMES,point.y).inArray(coordinats)&&Point(point.x-Constance.SIZE_IMG_FOR_GAMES,point.y).inDekstope(cx,cy)) {
                    var temp= Point(point.x-Constance.SIZE_IMG_FOR_GAMES,point.y)
                    pool.add(temp)
                }
                if (Point(point.x,point.y+Constance.SIZE_IMG_FOR_GAMES).inArray(coordinats)&&Point(point.x,point.y+Constance.SIZE_IMG_FOR_GAMES).inDekstope(cx,cy)) {
                    var temp= Point(point.x,point.y+Constance.SIZE_IMG_FOR_GAMES)
                    pool.add(temp)
                }
                if (Point(point.x,point.y-Constance.SIZE_IMG_FOR_GAMES).inArray(coordinats)&&Point(point.x,point.y-Constance.SIZE_IMG_FOR_GAMES).inDekstope(cx,cy)) {
                    var temp= Point(point.x,point.y-Constance.SIZE_IMG_FOR_GAMES)
                    pool.add(temp)
                }
            }
            coordinats.add(pool[Random.nextInt(0,pool.size)])
        }

        for (i in 0 until coordinats.size) {
            val img = ImageView(parent.context)
            cells.add(img)
            img.setImageResource(R.drawable.field)

            val params = RelativeLayout.LayoutParams(Constance.SIZE_IMG_FOR_GAMES, Constance.SIZE_IMG_FOR_GAMES)
            params.leftMargin = coordinats[i].x
            params.topMargin = coordinats[i].y
            //img.layoutParams = params // второй вариант

            parent.addView(img, params) // parent.addView(img) // второй вариант

        }
    }


    fun figureDetection(figure: Block):Boolean{
        var detective_field = arrayListOf<Point>()
        for (block in figure.coordinatsBlock){
            for(field in coordinats){
                if(block.y >= field.y && block.y <= field.y+50
                    && block.x <= field.x +50 && block.x >= field.x && !block.inDetectivePos(detective_coordinats)) {
                    detective_field.add(field)
                }
            }
        }
        if(detective_field.size == figure.coordinatsBlock.size){
            for (block in detective_field) {
                detective_coordinats.add(block)
                cells[coordinats.indexOf(block)].setImageResource(R.drawable.gold)
            }
            return true
        }
        return false
    }




}
