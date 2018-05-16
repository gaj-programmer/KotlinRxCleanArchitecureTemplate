package com.android.gajraj.sample.template.data.net

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.smit.android.data.BuildConfig
import com.android.gajraj.sample.template.data.entity.RefreshTokenRequest
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.util.*

import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Gajraj on 5/7/2018.
 */
@Singleton
class TokenInterceptor @Inject constructor(private val context: Context, serviceHolder: ServiceHolder) : Interceptor {

    private val mPrefs: SharedPreferences
    private var serviceHolder: ServiceHolder

    init {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        this.serviceHolder = serviceHolder
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        var newRequest: Request = chain!!.request()

        val expireTime = mPrefs.getLong("expireTime", 0)
        val c = Calendar.getInstance()
        val nowDate = c.getTime()
        c.setTimeInMillis(expireTime)
        val expireDate = c.getTime()

        val result = nowDate.compareTo(expireDate)
        var newAccessToken: String? = null
        if (result == -1) {
            val accessToken: String = BuildConfig.ACCESS_TOKEN
            val refreshToken: String = BuildConfig.REFRESH_TOKEN
            val refreshTokenRequest: RefreshTokenRequest = RefreshTokenRequest()
            refreshTokenRequest.deviceToken = accessToken
            refreshTokenRequest.refreshToken = refreshToken
            refreshTokenRequest.deviceUid = mPrefs.getString("deviceId", "")
            refreshTokenRequest.username = mPrefs.getString("username", "")
            serviceHolder.get()?.doUpdateToken(accessToken, refreshTokenRequest)?.doOnNext { newAccessToken = it.refreshToken }
            newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", newAccessToken)
                    .build()
        }


        return chain.proceed(newRequest)
    }

}