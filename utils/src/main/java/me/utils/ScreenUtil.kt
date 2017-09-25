package me.utils

import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Bitmap
import android.util.DisplayMetrics
import android.view.Surface
import android.view.Window
import android.view.WindowManager


object ScreenUtil {

    fun getScreenWidth(): Int = Utils.context.resources.displayMetrics.widthPixels

    fun getScreenHeight(): Int = Utils.context.resources.displayMetrics.heightPixels

    fun setFullScreen(activity: Activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun setLandscape(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    fun setPortrait(activity: Activity) {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun isLandscape(): Boolean =
            Utils.context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    fun isPortrait(): Boolean =
            Utils.context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    fun getScreenRotation(activity: Activity): Int =
            when (activity.windowManager.defaultDisplay.rotation) {
                Surface.ROTATION_0 -> 0
                Surface.ROTATION_90 -> 90
                Surface.ROTATION_180 -> 180
                Surface.ROTATION_270 -> 270
                else -> 0
            }

    fun screenShot(activity: Activity, isDeleteStatusBar: Boolean): Bitmap {
        val decorView = activity.window.decorView
        decorView.isDrawingCacheEnabled = true
        decorView.buildDrawingCache()
        val bmp = decorView.drawingCache
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        val ret: Bitmap
        ret = if (isDeleteStatusBar) {
            val resources = activity.resources
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            val statusBarHeight = resources.getDimensionPixelSize(resourceId)
            Bitmap.createBitmap(bmp, 0, statusBarHeight, dm.widthPixels, dm.heightPixels - statusBarHeight)
        } else {
            Bitmap.createBitmap(bmp, 0, 0, dm.widthPixels, dm.heightPixels)
        }
        decorView.destroyDrawingCache()
        return ret
    }

    fun isScreenLock(): Boolean {
        val km = Utils.context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        return km.inKeyguardRestrictedInputMode()
    }

    fun isTablet(): Boolean = Utils.context.resources.configuration.screenLayout and
            Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
}