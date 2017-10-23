package cn.wsgwz.draw

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.Toast
import cn.wsgwz.draw.util.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*imageView.setBackgroundDrawable(CartDrawable(this,100,true))

        var i:Int = 0
        imageView.setOnClickListener {
            Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()

            val cartDrawable:CartDrawable = imageView.background as CartDrawable

            cartDrawable.setCatNum(""+i++)
            cartDrawable.sta }
*/

        val arrayList:ArrayList<String> = ArrayList()
       for(i in 1..20){
           arrayList.add(""+i)
       }
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList)
        list_baseContent.adapter = arrayAdapter

        if(true){
            val arrayList:ArrayList<String> = ArrayList()
            for(i in 1..20){
                arrayList.add(""+i)
            }
            val arrayAdapter:ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList)
            list_baseContent2.adapter = arrayAdapter
        }




     /*   webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setLoadsImagesAutomatically(true)
        webView.loadUrl("https://www.baidu.com")*/
        //webView.settings.javaScriptEnabled = true



        NetworkUtil.isNetworkAvailable(this)


    }

    override fun onBackPressed() {
        super.onBackPressed()
       // if ( webView.canGoBack() )webView.goBack()

    }
}
