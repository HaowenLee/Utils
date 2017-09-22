package me.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.utils.DeviceUtil
import me.utils.Utils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.init(this)

        println("===============>>  ${DeviceUtil.isRooted()}")

        println("===============>>  ${DeviceUtil.getSDKVersion()}")

        println("===============>>  ${DeviceUtil.getAndroidID()}")

        println("===============>>  ${DeviceUtil.getModel()}")

        println("===============>>  ${DeviceUtil.getManufacturer()}")
    }
}
