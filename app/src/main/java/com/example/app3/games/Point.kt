package com.example.app3.games

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class Point(var x: Int = 0, var y :Int= 0) {
     fun inArray(array: ArrayList<Point>):Boolean{
        for (index in array){

            if(index.x==this.x && index.y==this.y){
                return false
            }
        }
        return true
    }

    fun inDetectivePos(array: ArrayList<Point>): Boolean {
        for(field in array){
            if(this.y >= field.y && this.y <= field.y+50
                && this.x <= field.x +50 && this.x >= field.x ) {
                return true
            }
        }
        return false
    }


    fun inDekstope(centeX:Int,centeY: Int):Boolean{
        return this.x-50>0&&this.y>0-50&&this.x+50<centeX*2&&this.y+50<centeY*2
    }

}