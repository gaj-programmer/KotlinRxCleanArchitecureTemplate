package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.cache.DBHelper
import com.android.gajraj.sample.template.data.entity.ItemsResponse
import com.android.gajraj.sample.template.data.entity.LoginRequest
import com.android.gajraj.sample.template.data.entity.LoginResponse
import com.android.gajraj.sample.template.data.net.RestApi
import rx.Observable

/**
 * Created by Gajraj on 4/21/2018.
 */
class CloudDataStoreImpl(private val restApi: RestApi, private val dbHelper: DBHelper) : CloudDataStore {
    override fun items(token: String?): Observable<ItemsResponse> {
        return restApi.items(token)
    }

    override fun authentication(loginRequest: LoginRequest?): Observable<LoginResponse> {
        return restApi.authentication(loginRequest)
    }

}