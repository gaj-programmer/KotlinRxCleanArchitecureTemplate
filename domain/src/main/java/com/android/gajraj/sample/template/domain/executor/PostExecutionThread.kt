package com.android.gajraj.sample.template.domain.executor

import rx.Scheduler

/**
 * Created by Gajraj on 4/25/2018.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}