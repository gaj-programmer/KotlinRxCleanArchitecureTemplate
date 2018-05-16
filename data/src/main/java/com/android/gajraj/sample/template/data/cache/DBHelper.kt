package com.android.gajraj.sample.template.data.cache

import io.realm.Realm
import javax.inject.Inject


/**
 * Created by Gajraj on 4/21/2018.
 */
class DBHelper @Inject constructor() {
    private val realm: Realm = Realm.getDefaultInstance()

//    fun save(loginResponseEntity: LoginResponseEntity) {
//        realm.beginTransaction()
//        realm.copyToRealmOrUpdate(loginResponseEntity)
//        realm.commitTransaction()
//    }



}