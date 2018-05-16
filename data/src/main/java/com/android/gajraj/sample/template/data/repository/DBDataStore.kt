package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.entity.LoginResponseEntity
import rx.Observable

/**
 * Created by Gajraj on 4/23/2018.
 */
interface DBDataStore{
    fun getLoggedInUserData(userId : String) : Observable<LoginResponseEntity>
}