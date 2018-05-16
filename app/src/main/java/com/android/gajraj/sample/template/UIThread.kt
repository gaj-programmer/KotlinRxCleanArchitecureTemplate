package com.android.gajraj.sample.template

import com.android.gajraj.sample.template.domain.executor.PostExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/26/2018.
 */
@Singleton
class UIThread
@Inject
constructor() : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}