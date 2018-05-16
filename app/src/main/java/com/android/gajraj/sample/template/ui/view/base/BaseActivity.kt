package com.android.gajraj.sample.template.ui.view.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by Gajraj on 4/28/2018.
 */
abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(layoutId())
    }


    protected abstract fun inject()
    protected abstract fun attachPresenter()

}