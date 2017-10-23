package cn.wsgwz.draw.util

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE



/**
 * Created by admin on 2017/10/18 0018.
 */
class Util {


    companion object {
        /**
         * 包名判断是否为主进程

         * @param context
         * *
         * @return
         */
        fun isMainProcess(context: Context): Boolean {
            return context.getPackageName().equals(getProcessName(context))
        }

        /**
         * 获取进程名称

         * @param context
         * *
         * @return
         */
        fun getProcessName(context: Context): String? {
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val runningApps = am.runningAppProcesses ?: return null
            for (proInfo in runningApps) {
                if (proInfo.pid == android.os.Process.myPid()) {
                    if (proInfo.processName != null) {
                        return proInfo.processName
                    }
                }
            }
            return null
        }
    }

}