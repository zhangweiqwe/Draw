package cn.wsgwz.draw

import android.app.Activity
import android.app.Application
import cn.wsgwz.draw.util.MLog
import cn.wsgwz.draw.util.Util

/**
 * Created by admin on 2017/10/18 0018.
 */
class MyApplication: Application() {

    val activitys = ArrayList<Activity>()
    companion object {
        val tag = MyApplication.toString()
    }
    override fun onCreate() {
        super.onCreate()
        MLog.d(MyApplication.tag,"onCreate()")
        if(Util.isMainProcess(this)){

        }
    }

    fun exit(){
        MLog.d(MyApplication.tag,"exit()")
        for(activity in activitys){
            if(activity!=null){
                activity.finish()
            }
        }
        System.exit(0)
    }

    fun addActivity(activity: Activity):Boolean{
        MLog.d(MyApplication.tag,"addActivity")
        return activitys.add(activity)
    }

}