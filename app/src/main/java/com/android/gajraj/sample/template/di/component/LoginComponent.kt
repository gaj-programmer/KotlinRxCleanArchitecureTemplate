package com.android.gajraj.sample.template.di.component

import com.android.gajraj.sample.template.di.module.LoginModule
import com.android.gajraj.sample.template.di.scope.LoginScope
import com.android.gajraj.sample.template.ui.view.LoginActivity
import dagger.Component

/**
 * Created by Gajraj on 4/26/2018.
 */
@LoginScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules=arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)
}