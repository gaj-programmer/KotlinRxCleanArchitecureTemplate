package com.android.gajraj.sample.template.data.repository

import com.android.gajraj.sample.template.data.entity.mapper.CompaniesMapper
import com.android.gajraj.sample.template.data.entity.mapper.LoginMapper
import com.android.gajraj.sample.template.domain.model.ItemsResponseVO
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import com.android.gajraj.sample.template.domain.repository.Repository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Gajraj on 4/23/2018.
 */
class RepositoryImpl
@Inject
constructor(
        private val loginMapper: LoginMapper,
        private val companiesMapper: CompaniesMapper,
        private val dataFactory: DataFactory
) : Repository {

    override fun companies(token: String?): Observable<ItemsResponseVO> {
        return dataFactory.createCloudDataStore().items(token).map { companiesMapper.transform(it) }
    }

    override fun authentication(loginVOEntity: LoginRequestVO?): Observable<LoginResponseVO> {
        return dataFactory.createCloudDataStore().authentication(loginMapper.transform(loginVOEntity)).map({ loginMapper.transform(it) })
    }
}