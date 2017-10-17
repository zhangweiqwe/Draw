package cn.wsgwz.draw

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.v4.widget.ImageViewCompat
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by admin on 2017/10/17 0017.
 */
class OtherImageView:  ImageView{
    companion object {
        val tag:String = OtherImageView.toString()
    }
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        MLog.d(OtherImageView.tag,canvas.toString()+"<--")

    }

}