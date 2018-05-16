package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.cache.DBHelper
import com.android.gajraj.sample.template.data.net.RestApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/21/2018.
 */
@Singleton
class DataFactory @Inject constructor(private val restApi: RestApi, val dbHelper: DBHelper) {
    fun createCloudDataStore(): CloudDataStore {
        return CloudDataStoreImpl(restApi, dbHelper)
    }

    fun createDBDataStore(): DBDataStore {
        return DBDataStoreImpl(dbHelper)
    }
}