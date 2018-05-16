package com.android.gajraj.sample.template.ui.presenter

import android.util.Log
import com.android.gajraj.sample.template.domain.model.ItemsResponseVO
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import com.android.gajraj.sample.template.domain.usecase.ItemsUseCase
import com.android.gajraj.sample.template.domain.usecase.LoginUseCase
import com.android.gajraj.sample.template.ui.presenter.base.BasePresenter
import com.android.gajraj.sample.template.ui.view.LoginView
import rx.lang.kotlin.FunctionSubscriber
import javax.inject.Inject

/**
 * Created by Gajraj on 4/25/2018.
 */
class LoginPresenter
@Inject
constructor(
        private val loginUseCase: LoginUseCase,
        private val itemsUseCase: ItemsUseCase
) : BasePresenter<LoginView> {
    lateinit private var view: LoginView
    override fun onCreate() {
        //Presenter's OnCreate()
    }

    override fun <T> onStart(arg: T) {
        view.showLoading("Authenticating user...", "Please wait")
        loginUseCase.setLoginVO(arg as LoginRequestVO)
        loginUseCase.execute(FunctionSubscriber<LoginResponseVO>()
                .onNext {
                    Log.e("", "Success Login:" + it.data?.username);
                    view.hideLoading()
                    view.clearFields()
                    view.clearFocus()
                    view.saveUser(it)
                    fetchCompanies(it.data?.token)
                }
                .onError {
                    Log.e("", "Getting error while Login:" + it.message);
                    view.hideLoading()
                    view.clearFields()
                    view.clearFocus()
                    view.showError(it)
                })
    }

    override fun attachView(view: LoginView) {
        this.view = view;
    }

    fun fetchCompanies(token: String?) {
        itemsUseCase.token = token
        itemsUseCase.execute(FunctionSubscriber<ItemsResponseVO>()
                .onNext {
                    view.hideLoading()
                    processCompaniesResponse(it)
                }
                .onError {
                    view.hideLoading()
                    view.showError(it)
                }
        )
    }

    private fun processCompaniesResponse(itemsResponseVO: ItemsResponseVO) {
        view.redirectToHomeScreen()
    }

    override fun onStop() {
    }
}