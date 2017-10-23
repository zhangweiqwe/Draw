package cn.wsgwz.draw.util

import android.content.Context

/**
 * Created by admin on 2017/10/17 0017.
 */
class DensityUtil {

    companion object {
        fun dp2px(context:Context,dpValues:Float):Float{
            return dpValues*context.resources.displayMetrics.density
        }

        fun px2dp(context:Context,dpValues:Float):Float{
            return dpValues/context.resources.displayMetrics.density
        }
    }

}