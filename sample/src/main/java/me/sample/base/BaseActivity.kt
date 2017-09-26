package me.sample.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutResID())

        initViews()
        initListener()
        doBusiness()
    }

    @LayoutRes
    abstract fun initLayoutResID(): Int

    open protected fun initViews() {}

    open protected fun initListener() {}

    open fun doBusiness() {}
}