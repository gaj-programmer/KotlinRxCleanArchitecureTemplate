package com.android.gajraj.sample.template.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Gajraj on 4/19/2018.
 */
class RefreshTokenResponse() {

    @SerializedName("token")
    var deviceToken: String? = null

    @SerializedName("token_expiry")
    var refreshToken: String? = null

}