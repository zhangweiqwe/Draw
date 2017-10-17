package cn.wsgwz.draw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setBackgroundDrawable(CartDrawable(this,100,true))

        var i:Int = 0
        imageView.setOnClickListener {
            Toast.makeText(this,"click",Toast.LENGTH_SHORT).show()

            val cartDrawable:CartDrawable = imageView.background as CartDrawable

            cartDrawable.setCatNum(""+i++)
            cartDrawable.start()
        }

    }
}
