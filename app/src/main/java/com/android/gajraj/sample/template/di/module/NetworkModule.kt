package com.android.gajraj.sample.template.di.module

import com.android.gajraj.sample.template.data.executor.JobExecutor
import com.android.gajraj.sample.template.data.repository.RepositoryImpl
import com.android.gajraj.sample.template.domain.executor.PostExecutionThread
import com.android.gajraj.sample.template.domain.executor.ThreadExecutor
import com.android.gajraj.sample.template.domain.repository.Repository
import com.android.gajraj.sample.template.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/26/2018.
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideRepository(RepositoryImpl: RepositoryImpl): Repository {
        return RepositoryImpl
    }

}