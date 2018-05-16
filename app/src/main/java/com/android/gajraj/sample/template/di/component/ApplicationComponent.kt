package com.android.gajraj.sample.template.di.component

import android.content.Context
import com.android.gajraj.sample.template.domain.executor.PostExecutionThread
import com.android.gajraj.sample.template.domain.executor.ThreadExecutor
import com.android.gajraj.sample.template.domain.repository.Repository
import com.android.gajraj.sample.template.MyApplication
import com.android.gajraj.sample.template.di.module.ApplicationModule
import com.android.gajraj.sample.template.di.module.LoginModule
import com.android.gajraj.sample.template.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/25/2018.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class,LoginModule::class))
interface ApplicationComponent {
    fun inject(myApplication: MyApplication)
    val myApplication: MyApplication
    fun context(): Context
    fun realEstateRepository(): Repository
    fun threadExecutor(): ThreadExecutor
    fun postExecutionThread():PostExecutionThread
}