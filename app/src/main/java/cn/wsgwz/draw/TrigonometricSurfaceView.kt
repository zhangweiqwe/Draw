package cn.wsgwz.draw

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import java.util.*
import android.graphics.RectF



@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
/**
 * Created by admin on 2017/10/16 0016.
 */
class TrigonometricSurfaceView: SurfaceView,SurfaceHolder.Callback {

    companion object {
        val tag:String = TrigonometricSurfaceView.toString()
    }
    private val displayMetrics = DisplayMetrics()


    private var timer:Timer? = null

    private var angle = 0f


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
        MLog.d(TrigonometricSurfaceView.tag,"surfaceChanged")




    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        timer?.cancel()
        timer = null
        MLog.d(TrigonometricSurfaceView.tag,"surfaceDestroyed")

    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        MLog.d(TrigonometricSurfaceView.tag,"surfaceCreated")


        if (timer == null) {
            timer = Timer()
        }

        timer?.schedule(DrawTimerTask(), 2000,3000)
    }



    init {

        if(context is Activity){
            val activity = context as Activity
            activity.windowManager.defaultDisplay.getRealMetrics(displayMetrics)
        }


        holder.addCallback(this)


        MLog.d(TrigonometricSurfaceView.tag,"init")
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)
    }

    private inner class DrawTimerTask: TimerTask() {
        override fun run() {

            MLog.d(TrigonometricSurfaceView.tag,"DrawTimerTask")

            val canvas = holder.lockCanvas()
            draw(canvas)



            val paint = Paint()
            paint.isAntiAlias = true
            paint.color = Color.RED
            paint.strokeWidth = DensityUtil.dp2px(context,2f)

            val path = Path()
            path.moveTo(80f, 200f)
            path.lineTo(120f, 250f)
            path.lineTo(80f, 250f)
            path.close()

            canvas.drawPath(path,paint)


            angle+=10
            val rectF = RectF(60f, 100f, 200f, 240f)

            angle+=10
            if(!(angle in 0..360)){
                angle = 0f
            }
            canvas.drawArc(rectF, 0f, angle, true, paint)


            var x = 10f

            val range = 1.rangeTo(5)
            for (i in range) {
                x+=10
                canvas.drawText(""+i,x,700f,paint)
            }



            //canvas.drawLine(0f, (displayMetrics.heightPixels/2).toFloat(),displayMetrics.widthPixels.toFloat(), (displayMetrics.heightPixels/2).toFloat(),paint)
            holder.unlockCanvasAndPost(canvas)
        }
    }


}