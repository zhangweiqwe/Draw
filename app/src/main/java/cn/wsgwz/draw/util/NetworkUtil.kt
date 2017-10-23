package cn.wsgwz.draw.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build

/**
 * Created by admin on 2017/10/18 0018.
 */
class NetworkUtil {
    companion object {
        val tag:String = NetworkUtil.toString()

        fun isNetworkAvailable(context:Context):Boolean{
            val c:ConnectivityManager? = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if(c!=null){


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val n:Array<Network>? = c.allNetworks

                    if(n!=null&&n.size>0){
                        for(network in n){
                            var networkInfo:NetworkInfo = c.getNetworkInfo(network)
                            MLog.d(tag, networkInfo.toString())
                            if(networkInfo.state == NetworkInfo.State.CONNECTED){
                                return true
                            }
                        }
                    }
                }else{
                    val n:Array<NetworkInfo>? = c.allNetworkInfo
                    if(n!=null&&n.size>0){
                        for(networkInfo in n){

                            MLog.d(tag, networkInfo.toString())
                            if(networkInfo.state == NetworkInfo.State.CONNECTED){
                                return true
                            }
                        }
                    }

                }

            }

            return false
        }
    }
}