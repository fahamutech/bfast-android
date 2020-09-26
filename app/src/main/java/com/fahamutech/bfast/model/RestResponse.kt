package com.fahamutech.bfast.model

data class RestResponse<T : Any>(
    var data: T? = null,
    var status: Int? = null,
    var statusText: String? = null,
    var headers: Any? = null,
    var config: RestRequestConfig? = null,
    var request: Any? = null
)