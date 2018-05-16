package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.cache.DBHelper
import com.android.gajraj.sample.template.data.entity.LoginResponseEntity
import rx.Observable
import java.lang.UnsupportedOperationException

/**
 * Created by Gajraj on 4/23/2018.
 */
class DBDataStoreImpl(private val dbHelper: DBHelper) : DBDataStore {
    override fun getLoggedInUserData(userId: String): Observable<LoginResponseEntity> {
        throw UnsupportedOperationException()
    }
}