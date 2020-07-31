package com.nekomimi.demo.view

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorInt

/**
 * Created by Nekomimi on 2020/7/29.
 */
class ControllerView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val maxSize : Float = 300f
    val minSize : Float = 200f
    val maxPointSize : Float = 130f
    val minPointSize : Float = 0f

    private var size : Float = 0.0f
    private var pointSize : Float = 0.0f
    @ColorInt private var bgColor : Int = Color.LTGRAY
    @ColorInt private var pointColor : Int = Color.DKGRAY
    private  var xPoint : Float = 0.0f
    private  var yPoint : Float = 0.0f
    private var paint : Paint = Paint()

    private lateinit var animation : ObjectAnimator

    init {
        size = minSize
        pointSize = 100f
        animation = ObjectAnimator.ofFloat(this, "pointSize",pointSize, maxPointSize)
    }

    fun setPointSize(float: Float){
        pointSize = float
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.reset()
        paint.apply {
            this.color = bgColor
        }
        canvas?.drawCircle(width.toFloat()/2, height.toFloat()/2, size, paint)
        if(xPoint!= 0f && yPoint!=0f && pointSize!=0f){
            paint.apply {
                this.color = pointColor
            }
            canvas?.drawCircle(xPoint, yPoint, pointSize, paint)
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.x?.let { xPoint = it }
        event?.y?.let { yPoint = it }

        if(event?.action == MotionEvent.ACTION_UP){
            if(animation.isRunning){
                animation.cancel()
            }
            animation.apply {
                this.setFloatValues(pointSize, minPointSize)
            }
            animation.start()
        }else{
            pointSize = 100f
        }
        invalidate()
        return true
    }



}