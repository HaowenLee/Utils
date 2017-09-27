package me.sample.activity

import ImageUtil
import android.graphics.BitmapFactory
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.SeekBar
import android.widget.Toast
import com.commit451.nativestackblur.NativeStackBlur
import kotlinx.android.synthetic.main.activity_blur.*
import me.sample.R
import me.sample.base.BaseActivity

class BlurActivity : BaseActivity() {

    override fun initLayoutResID(): Int = R.layout.activity_blur

    override fun initViews() {
        super.initViews()
        seekBar.max = 254
        smallImageView.setImageBitmap(ImageUtil.toRound(BitmapFactory.decodeResource(resources,
                R.drawable.blur), true))

        val anim = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        anim.interpolator = LinearInterpolator()
        anim.duration = 8000
        anim.repeatCount = Animation.INFINITE
        smallImageView.startAnimation(anim)
    }

    override fun initListener() {
        super.initListener()
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.text = (seekBar?.progress ?: 0).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val startTime = System.currentTimeMillis()
                imageView.setImageBitmap(NativeStackBlur.process(BitmapFactory.decodeResource(resources,
                        R.drawable.blur), seekBar?.progress ?: 0))
                Toast.makeText(this@BlurActivity, "${System.currentTimeMillis() - startTime}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}