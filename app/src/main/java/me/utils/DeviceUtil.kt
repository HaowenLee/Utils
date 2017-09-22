package me.utils

import android.os.Build
import android.provider.Settings
import java.io.File


object DeviceUtil {

    fun isRooted(): Boolean {
        val su = "su"
        val locations = arrayOf(
                "/system/bin/",
                "/system/xbin/",
                "/sbin/",
                "/system/sd/xbin/",
                "/system/bin/failsafe/",
                "/data/local/xbin/",
                "/data/local/bin/",
                "/data/local/")
        return locations.any { File(it + su).exists() }
    }

    fun getSDKVersion(): Int = android.os.Build.VERSION.SDK_INT

    fun getAndroidID() = Settings.Secure.getString(Utils.context.contentResolver, Settings.Secure.ANDROID_ID) ?: ""

    fun getManufacturer(): String = Build.MANUFACTURER ?: ""

    fun getModel(): String {
        var model = Build.MODEL ?: ""
        if (model.isNotEmpty()) model = model.trim().replace("\\s*", "")
        return model
    }
}