package com.android.gajraj.sample.template.domain.repository

import com.android.gajraj.sample.template.domain.model.ItemsResponseVO
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import rx.Observable

/**
 * Created by Gajraj on 4/23/2018.
 */
interface Repository {
    fun authentication(loginVOEntity: LoginRequestVO?): Observable<LoginResponseVO>
    fun companies(token: String?): Observable<ItemsResponseVO>
}