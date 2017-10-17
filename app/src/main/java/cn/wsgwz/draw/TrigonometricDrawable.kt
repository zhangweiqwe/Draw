package cn.wsgwz.draw

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * Created by admin on 2017/10/17 0017.
 */
class TrigonometricDrawable:Drawable {
    override fun draw(p0: Canvas?) {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.RED
        paint.strokeWidth = 2*3f

        val path = Path()
        path.moveTo(80f*3, 200f*3)
        path.lineTo(120f*3, 250f*3)
        path.lineTo(80f*3, 250f*3)
        path.close()

        p0?.drawPath(path,paint)
    }

    override fun setAlpha(p0: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(p0: ColorFilter?) {
    }

    constructor() : super()


    override fun getIntrinsicWidth(): Int {
        return 100
    }

    override fun getIntrinsicHeight(): Int {
        return 100
    }
}