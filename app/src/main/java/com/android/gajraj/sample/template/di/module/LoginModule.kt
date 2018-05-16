package com.android.gajraj.sample.template.di.module

import com.android.gajraj.sample.template.domain.usecase.ItemsUseCase
import com.android.gajraj.sample.template.domain.usecase.LoginUseCase
import com.android.gajraj.sample.template.di.scope.LoginScope
import com.android.gajraj.sample.template.ui.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Gajraj on 4/26/2018.
 */
@Module
class LoginModule {

    @LoginScope
    @Provides
    fun providePresenter(loginUseCase: LoginUseCase, itemsUseCase: ItemsUseCase)
            : LoginPresenter = LoginPresenter(loginUseCase, itemsUseCase)
}