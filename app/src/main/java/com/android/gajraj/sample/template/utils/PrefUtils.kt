package com.android.gajraj.sample.template.utils

import android.content.Context
import com.android.gajraj.sample.template.domain.model.LoginResponseVO


object PrefUtils {
    val MyPREFERENCES = "MySample"
    fun clearPrefs(context: Context) {
        val sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.clear()
        editor.commit()
    }

    fun saveToPrefs(context: Context, loginResponse: LoginResponseVO) {
        val sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.putString(Constants.Login.USER_ID, loginResponse.data?.userId.toString())
        editor.putString(Constants.Login.USER_NAME, loginResponse.data?.username)
        editor.putString(Constants.Login.AUTH_TOKEN, loginResponse.data?.token)
        editor.commit()
    }

    fun setLoggedIn(context: Context) {
        val sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedpreferences.edit()
        editor.putBoolean(Constants.Login.Logged_In, true)
        editor.commit()
    }
}
