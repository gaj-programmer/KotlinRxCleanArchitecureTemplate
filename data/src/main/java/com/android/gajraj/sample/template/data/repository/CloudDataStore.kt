package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.entity.ItemsResponse
import com.android.gajraj.sample.template.data.entity.LoginRequest
import com.android.gajraj.sample.template.data.entity.LoginResponse
import rx.Observable

/**
 * Created by Gajraj on 4/21/2018.
 */
interface CloudDataStore {
    fun authentication(loginRequest: LoginRequest?): Observable<LoginResponse>
    fun items(token: String?): Observable<ItemsResponse>
}