package com.android.gajraj.sample.template.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Gajraj on 4/19/2018.
 */
class LoginRequest() {
    @SerializedName("appversion")
    var applicationVersion: String? = null

    @SerializedName("accountno")
    var accountNumber: String? = null

    @SerializedName("devicemodel")
    var deviceModel: String? = null

    @SerializedName("deviceversion")
    var deviceVersion: String? = null

    @SerializedName("deviceos")
    var deviceOS: String? = null

    @SerializedName("password")
    var password: String? = null

    @SerializedName("devicetoken")
    var deviceToken: String? = null

    @SerializedName("environment")
    var environment: String? = null

    @SerializedName("deviceuid")
    var deviceUid: String? = null

    @SerializedName("username")
    var username: String? = null

    @SerializedName("apptype")
    var applicationType: String? = null
}