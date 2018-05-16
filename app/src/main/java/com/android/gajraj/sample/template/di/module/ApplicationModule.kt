package com.android.gajraj.sample.template.di.module

import android.content.Context
import com.android.gajraj.sample.template.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/25/2018.
 */

@Module
class ApplicationModule(private val myApplication: MyApplication) {

    @Provides
    @Singleton
    fun application(): MyApplication {
        return myApplication
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return myApplication
    }

}