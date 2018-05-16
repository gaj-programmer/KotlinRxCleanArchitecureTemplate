package com.android.gajraj.sample.template.domain.usecase

import com.android.gajraj.sample.template.domain.executor.PostExecutionThread
import com.android.gajraj.sample.template.domain.executor.ThreadExecutor
import com.android.gajraj.sample.template.domain.model.ItemsResponseVO
import com.android.gajraj.sample.template.domain.repository.Repository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Gajraj on 4/25/2018.
 */
class ItemsUseCase @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                       private val Repository: Repository) : UseCase<ItemsResponseVO>(threadExecutor, postExecutionThread) {

    var token: String? = null

    override fun buildUseCaseObservable(): Observable<ItemsResponseVO> {
        return this.Repository.companies(token)
    }
}