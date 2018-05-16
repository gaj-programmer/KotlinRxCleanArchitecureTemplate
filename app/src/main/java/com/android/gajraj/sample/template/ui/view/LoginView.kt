package com.android.gajraj.sample.template.ui.view

import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import com.android.gajraj.sample.template.ui.view.base.View

/**
 * Created by Gajraj on 4/25/2018.
 */
interface LoginView : View {
    fun attachPresenter()
    fun clearFields()
    fun clearFocus()
    fun saveUser(loginResponseVO: LoginResponseVO)
    fun redirectToHomeScreen()
    fun redirectToCompaniesScreen()
}