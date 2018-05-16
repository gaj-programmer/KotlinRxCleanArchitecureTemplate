package com.android.gajraj.sample.template.data.net

import android.content.Context
import com.google.gson.Gson
import com.android.gajraj.sample.template.data.entity.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/19/2018.
 */


@Singleton
class RestApi @Inject constructor(context: Context) {
    var apiService: ApiService
    var serviceHolder: ServiceHolder

    init {
        serviceHolder = ServiceHolder()
        val builder = OkHttpClient.Builder().addInterceptor(getLoggingInterceptor())
                .addInterceptor(TokenInterceptor(context, serviceHolder))

        val retro = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build()).build()
        apiService = retro.create(ApiService::class.java)
        serviceHolder.set(apiService)
    }

    fun authentication(loginRequest: LoginRequest?): Observable<LoginResponse> {
        var obj: Observable<LoginResponse> = apiService.doAuthentication(loginRequest);

        return obj
    }

    fun updateToken(refreshTokenRequest: RefreshTokenRequest?): Observable<RefreshTokenResponse> {
        return apiService.doUpdateToken(refreshTokenRequest?.deviceToken, refreshTokenRequest)
    }

    fun items(token: String?): Observable<ItemsResponse> {
        return apiService.doFetchItems(token)
    }

    fun getLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

}