package com.android.gajraj.sample.template.ui.presenter.base

import com.android.gajraj.sample.template.ui.view.base.View

/**
 * Created by Gajraj on 4/25/2018.
 */
interface BasePresenter<V : View> {
    fun attachView(view: V)
    fun onCreate()
    fun <T> onStart(arg : T)
    fun onStop()
}



