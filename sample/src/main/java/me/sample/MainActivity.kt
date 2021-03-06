package me.sample

import ImageUtil
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.sample.activity.ImageUtilActivity
import me.utils.ScreenUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScreenUtil.setFullScreen(this)
        setContentView(R.layout.activity_main)

        textView.setOnClickListener {
            startActivity(Intent(this, ImageUtilActivity::class.java))
            imageView.setImageBitmap(ImageUtil.compressBySampleSize(ScreenUtil.screenShot(this, false), 20, 20, true))
            textView.text = ScreenUtil.isTablet().toString()
        }

        println("${ScreenUtil.getScreenHeight()}  ${ScreenUtil.getScreenWidth()}")
    }
}
