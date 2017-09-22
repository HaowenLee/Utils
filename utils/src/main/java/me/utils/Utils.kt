package me.utils

import android.content.Context

object Utils {

    lateinit var context: Context

    fun init(context: Context) {
        Utils.context = context
    }
}