package com.example.app3.games

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.app3.databinding.ActivityGamesBinding

class Games : AppCompatActivity() {
    lateinit var bindingclass:ActivityGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass= ActivityGamesBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)

        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ALPHA_8)
        val canvas: Canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable

        // rectangle positions
        var left =5
        var top = 0
        var right = 5
        var bottom = 2

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009944"))
        shapeDrawable.draw(canvas)


        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        bindingclass.fieldGames.background = BitmapDrawable(getResources(), bitmap)
    }
}