package me.sample.activity

import android.content.Intent
import kotlinx.android.synthetic.main.activity_image_util.*
import me.sample.R
import me.sample.base.BaseActivity

class ImageUtilActivity : BaseActivity() {

    override fun initLayoutResID() = R.layout.activity_image_util

    override fun initListener() {
        super.initListener()
        btnBlur.setOnClickListener {
            startActivity(Intent(this@ImageUtilActivity, BlurActivity::class.java))
        }
    }
}