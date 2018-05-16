package com.android.gajraj.sample.template.data.entity.mapper

import com.android.gajraj.sample.template.data.entity.LoginRequest
import com.android.gajraj.sample.template.data.entity.LoginResponse
import com.android.gajraj.sample.template.domain.model.DataVO
import com.android.gajraj.sample.template.domain.model.LoginResponseVO
import com.android.gajraj.sample.template.domain.model.LoginRequestVO
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Gajraj on 4/21/2018.
 */
@Singleton
class LoginMapper @Inject constructor() : EntryEntityMapper<LoginRequestVO, LoginRequest>() {

    override fun transform(entity: LoginRequest?): LoginRequestVO? {
        if (entity != null) {
            val loginVO = LoginRequestVO()
            loginVO.applicationVersion = entity.applicationVersion
            loginVO.applicationType = entity.applicationType
            loginVO.accountNumber = entity.accountNumber
            loginVO.deviceModel = entity.deviceModel
            loginVO.deviceOS = entity.deviceOS
            loginVO.deviceModel = entity.deviceModel
            loginVO.deviceToken = entity.deviceToken
            loginVO.deviceUid = entity.deviceUid
            loginVO.deviceVersion = entity.deviceVersion
            loginVO.environment = entity.environment
            loginVO.password = entity.password
            loginVO.username = entity.username
            return loginVO
        }
        return null
    }


    fun transform(loginRequestVO: LoginRequestVO?): LoginRequest? {
        if (loginRequestVO != null) {
            val loginRequestEntity = LoginRequest()
            loginRequestEntity.accountNumber = loginRequestVO.accountNumber
            loginRequestEntity.username = loginRequestVO.username
            loginRequestEntity.applicationType = loginRequestVO.applicationType
            loginRequestEntity.applicationVersion = loginRequestVO.applicationVersion
            loginRequestEntity.deviceModel = loginRequestVO.deviceModel
            loginRequestEntity.deviceOS = loginRequestVO.deviceOS
            loginRequestEntity.deviceToken = loginRequestVO.deviceToken
            loginRequestEntity.deviceUid = loginRequestVO.deviceUid
            loginRequestEntity.deviceVersion = loginRequestVO.deviceVersion
            loginRequestEntity.environment = loginRequestVO.environment
            loginRequestEntity.password = loginRequestVO.password

            return loginRequestEntity
        }
        return null
    }

    fun transform(it: LoginResponse?): LoginResponseVO? {
        if (it != null) {
            var loginResponseVO = LoginResponseVO()
            val dataVO = DataVO()
            dataVO.userId = it.data?.userId
            dataVO.username = it.data?.username
            dataVO.token = it.data?.token
            dataVO.tokenExpiry = it.data?.tokenExpiry
            dataVO.refreshToken = it.data?.refreshToken
            dataVO.type = it.data?.type
            loginResponseVO.data = dataVO
            loginResponseVO.status = it.status
            return loginResponseVO
        }
        return null

    }

}