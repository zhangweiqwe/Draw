package cn.wsgwz.draw.util

import android.util.Log

/**
 * Created by admin on 2017/10/16 0016.
 */
class MLog {

    companion object {
        val isDebug:Boolean = true
        val overallSituationTag = "overall situation"

        fun d(tag:String,string:String){
            if(!isDebug){
               return
            }

            Log.d(overallSituationTag+" "+tag,string)
        }
    }

}