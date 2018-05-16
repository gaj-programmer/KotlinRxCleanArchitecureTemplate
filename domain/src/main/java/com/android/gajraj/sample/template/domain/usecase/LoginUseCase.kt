package com.android.gajraj.sample.template.domain.usecase

import com.android.gajraj.sample.template.domain.executor.PostExecutionThread
import com.android.gajraj.sample.template.domain.executor.ThreadExecutor
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import com.android.gajraj.sample.template.domain.repository.Repository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Gajraj on 4/25/2018.
 */
class LoginUseCase @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                       private val Repository: Repository) : UseCase<LoginResponseVO>(threadExecutor, postExecutionThread) {

    private var loginRequestVO: LoginRequestVO? = null
    fun setLoginVO(loginRequestVO: LoginRequestVO) {
        this.loginRequestVO=loginRequestVO
    }

    override fun buildUseCaseObservable(): Observable<LoginResponseVO> {
       return this.Repository.authentication(loginRequestVO)
    }
}