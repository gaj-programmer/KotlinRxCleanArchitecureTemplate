package com.android.gajraj.sample.template.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Gajraj on 4/19/2018.
 */
class RefreshTokenRequest() {

    var deviceToken: String? = null

    @SerializedName("refresh_token")
    var refreshToken: String? = null

    @SerializedName("deviceuid")
    var deviceUid: String? = null

    @SerializedName("username")
    var username: String? = null

}