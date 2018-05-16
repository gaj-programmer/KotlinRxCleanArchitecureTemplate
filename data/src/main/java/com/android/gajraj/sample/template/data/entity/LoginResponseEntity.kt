package com.android.gajraj.sample.template.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Gajraj on 5/19/2016.
 */


class LoginResponseEntity {

    @SerializedName("user_id")
    var userId: String = ""

    @SerializedName("username")
    var username: String = "0"

    @SerializedName("type")
    var type: String? = null

    @SerializedName("token")
    var token: String? = null

    @SerializedName("token_expiry")
    var tokenExpiryDate: String? = null

    @SerializedName("refresh_token")
    var tokenRefresh: String? = null

    @SerializedName("status")
    var status: String? = null


    var error: String? = null
    var reason: String? = null
}
