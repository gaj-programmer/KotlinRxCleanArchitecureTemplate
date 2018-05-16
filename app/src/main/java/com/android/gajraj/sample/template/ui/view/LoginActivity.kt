package com.android.gajraj.sample.template.ui.view

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.android.gajraj.sample.template.MyApplication
import com.android.gajraj.sample.template.R
import com.android.gajraj.sample.template.di.component.DaggerLoginComponent
import com.android.gajraj.sample.template.di.module.LoginModule
import com.android.gajraj.sample.template.ui.presenter.LoginPresenter
import com.android.gajraj.sample.template.ui.view.base.BaseActivity
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast
import javax.inject.Inject


/**
 * Created by Gajraj on 4/26/2018.
 */
class LoginActivity : BaseActivity(), LoginView, View.OnClickListener {

    @Inject
    lateinit var loginPresenter: LoginPresenter
    private var mPreferences: SharedPreferences? = null
    override fun layoutId() = R.layout.activity_login
    lateinit var dialog: ProgressDialog
    lateinit var loginButton: Button
    lateinit var etUsername: TextInputEditText
    lateinit var etPassword: TextInputEditText
    private val sharedPrefFile: String? = "gajraj.android.sample"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialization()
        attachPresenter()

    }

    private fun setSupportActionBar(title: CharSequence?) {
        setTitle("")
    }

    fun initialization() {
        loginButton = findViewById(R.id.button_login) as Button
        etPassword = findViewById(R.id.text_input_password) as TextInputEditText
        etUsername = findViewById(R.id.text_input_username) as TextInputEditText
        loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        hideSoftKeyboard(this)
        when (v?.id) {
            R.id.button_login -> authentication()
        }
    }

    private fun getSampleUserData(): LoginRequestVO {
        var loginVO = LoginRequestVO()
        loginVO.username = "s0001"
        loginVO.password = "Demo@321#"
        loginVO.accountNumber = "105424"
        loginVO.applicationType = "mobile"
        loginVO.deviceUid = "qwerty12341234"
        loginVO.environment = "development"
        return loginVO
    }

    private fun authentication() {
        var loginVO = LoginRequestVO()
        loginVO.username = etUsername.text.toString()
        loginVO.password = etPassword.text.toString()
        loginVO.accountNumber = "105424"
        loginVO.applicationType = "mobile"
        loginVO.deviceUid = "qwerty12341234"
        loginVO.environment = "development"

        loginPresenter.onStart(loginVO)
    }

    override fun inject() {
        DaggerLoginComponent.builder()
                .applicationComponent((application as MyApplication).component)
                .loginModule(LoginModule())
                .build().inject(this)

    }

    override fun attachPresenter() {
        loginPresenter.attachView(this)
    }

    override fun showError(throwable: Throwable) {
        dialog.dismiss()
        dialog.cancel()
        alert("Username or Password is incorrect") {
            title = "Real Estate"
            okButton { this.cancel() }
        }.show()
    }

    override fun showLoading(message: String, title: String) {
        dialog = indeterminateProgressDialog(message, title = title)
    }

    override fun hideLoading() {
        dialog.dismiss()
        dialog.cancel()
    }

    override fun clearFields() {
        etPassword.text.clear()
        etUsername.text.clear()
    }

    override fun clearFocus() {
        etPassword.clearFocus()
        etUsername.clearFocus()
    }

    override fun redirectToCompaniesScreen() {

    }

    override fun redirectToHomeScreen() {

    }

    override fun saveUser(loginResponseVO: LoginResponseVO) {
        toast("Successfully logged in")
        val sharedPref = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("tokenExpiry", loginResponseVO.data?.tokenExpiry.toString())
            putString("username", loginResponseVO.data?.username.toString())
            putString("userId", loginResponseVO.data?.userId.toString())
            commit()
        }
    }

    companion object {
        fun hideSoftKeyboard(activity: Activity) {
            val inputMethodManager = activity.getSystemService(
                    Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                    activity.currentFocus!!.windowToken, 0)
        }

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }
    }
}