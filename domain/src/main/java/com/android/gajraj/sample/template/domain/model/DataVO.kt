package com.android.gajraj.sample.template.domain.model

data class DataVO(
		var refreshToken: String? = null,
		var userId: Int? = null,
		var type: String? = null,
		var tokenExpiry: Int? = null,
		var username: String? = null,
		var token: String? = null
)
