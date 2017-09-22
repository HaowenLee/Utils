package me.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
