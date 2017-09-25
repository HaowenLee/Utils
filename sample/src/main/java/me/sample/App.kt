package me.sample

import android.app.Application
import me.utils.Utils

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }
}