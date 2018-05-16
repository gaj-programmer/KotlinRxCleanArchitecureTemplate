package com.android.gajraj.sample.template.ui.view.base

/**
 * Created by Gajraj on 4/25/2018.
 */
interface View {
    fun showError(throwable: Throwable)
    fun showLoading(message: String, title: String)
    fun hideLoading()
}