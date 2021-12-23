package com.example.app3.games

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.app3.databinding.GamesBinding


class Games : AppCompatActivity() {
    lateinit var bindingclass: GamesBinding
    lateinit var root: RelativeLayout
    lateinit var rootblock: RelativeLayout
    val blocks = ArrayList<Block>()
    var capturedBlock: Block? = null
    var lastX = 0
    var lastY = 0
    var downX = 0
    var downY = 0


    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingclass = GamesBinding.inflate(layoutInflater)
        setContentView(bindingclass.root)

        val displaymetrics = resources.displayMetrics



        root = bindingclass.root
        rootblock=bindingclass.rootblock
        var centerY = displaymetrics.heightPixels / 2
        var centerX = displaymetrics.widthPixels / 2

        val GamesField=Field(rootblock,30, centerX-25, centerY-25)

        root.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    for (block in blocks.reversed())
                        if (block.containsPoint(event.x.toInt(), event.y.toInt())) {
                            downX = event.x.toInt()
                            downY = event.y.toInt()
                            lastX = downX
                            lastY = downY
                            capturedBlock = block
                        }
                }
                MotionEvent.ACTION_MOVE -> {
                    if (capturedBlock != null) {
                        capturedBlock!!.move(
                            event.x.toInt() - lastX,
                            event.y.toInt() - lastY
                        )
                        lastX = event.x.toInt()
                        lastY = event.y.toInt()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (event.x.toInt() == downX && event.y.toInt() == downY) {
                        capturedBlock?.rotate()
                    }else{
                        if (capturedBlock != null) {
                           if(GamesField.figureDetection(capturedBlock!!)){
                               capturedBlock!!.delete()
                                blocks.remove(capturedBlock)
                           }
                        }
                    }
                    capturedBlock = null
                }
            }
            true
        }

        blocks.add(Block(root, 50, 0, 0, 50, 0, 50, 50, 100, 50, 100, 100))
        blocks.add(Block(root, 50, 200, 200, 200, 250, 200, 300))
        blocks.add(Block(root, 50, 200, 200, 200, 250, 200, 300))
        blocks.add(Block(root, 50, 200, 200, 200, 250, 200, 300))

    }
}

