package com.android.gajraj.sample.template.domain.exception

/**
 * Created by Gajraj on 4/25/2018.
 */
interface ErrorBundle {
    val exception: Exception

    val errorMessage: String
}