package me.utils

import java.io.Closeable
import java.io.IOException

object CloseUtil {

    init {
        println("=====================>  IO create==> ")
    }

    fun closeIO(vararg closeables: Closeable?) {
        for (closeable in closeables) {
            try {
                closeable?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}