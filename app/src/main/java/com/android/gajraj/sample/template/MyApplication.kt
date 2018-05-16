package com.android.gajraj.sample.template

import android.app.Application
import android.content.Context
import com.android.gajraj.sample.template.di.component.ApplicationComponent
import com.android.gajraj.sample.template.di.component.DaggerApplicationComponent
import com.android.gajraj.sample.template.di.module.ApplicationModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Gajraj on 4/25/2018.
 */
class MyApplication : Application() {

    val component: ApplicationComponent
        get() = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    override fun onCreate() {
        super.onCreate()
        initRealm()
        component.inject(this)
    }

    private fun initRealm() {
        val realmConfiguration: RealmConfiguration = RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    companion object {
        operator fun get(context: Context): MyApplication {
            return context.applicationContext as MyApplication
        }
    }

}