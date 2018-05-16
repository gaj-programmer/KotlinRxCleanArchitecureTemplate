package com.android.gajraj.sample.template.data.net

import com.android.gajraj.sample.template.data.entity.*

import retrofit2.http.*
import rx.Observable

/**
 * Created by Gajraj on 4/19/2018.
 */

interface ApiService {

    @POST(Constants.API_LOGIN)
    fun doAuthentication(@Body loginEnity: LoginRequest?): Observable<LoginResponse>

    @FormUrlEncoded
    @POST(Constants.API_UPDATE_TOKEN)
    fun doUpdateToken(@Header("Authorization") authToken: String?,
                      @Body refreshTokenRequest: RefreshTokenRequest?): Observable<RefreshTokenResponse>


    @GET(Constants.API_ITEMS)
    fun doFetchItems(@Header("auth-token") authToken: String?): Observable<ItemsResponse>

}