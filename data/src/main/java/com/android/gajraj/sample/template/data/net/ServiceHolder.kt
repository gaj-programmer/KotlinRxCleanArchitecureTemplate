package com.android.gajraj.sample.template.data.net

import android.support.annotation.Nullable

/**
 * Created by Gajraj on 5/8/2018.
 */

class ServiceHolder {

    internal var service: ApiService? = null

    @Nullable
    fun get(): ApiService? {
        return service
    }

    fun set(service: ApiService) {
        this.service = service
    }
}