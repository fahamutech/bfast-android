package com.fahamutech.bfast.model

import com.fahamutech.bfast.adapters.RestBasicCredentials
import com.fahamutech.bfast.adapters.RestMethod

data class RestRequestConfig(
    var url: String? = null,
    var method: RestMethod? = null,
    var baseURL: String? = null,
    var headers: Any? = null,
    var params: Any? = null,
    var data: Any? = null,
    var timeout: Int? = null,
    var timeoutErrorMessage: String? = null,
    var withCredentials: Boolean? = null,
    var auth: RestBasicCredentials? = null,
    var xsrfCookieName: String? = null,
    var xsrfHeaderName: String? = null,
    var onUploadProgress: (progressEvent: Any) -> Any,
    var onDownloadProgress: (progressEvent: Any) -> Any,
    var maxContentLength: Int? = null,
    var validateStatus: (status: Int) -> Boolean,
    var maxRedirects: Int? = null,
    var socketPath: String? = null,
    var httpAgent: Any? = null,
    var httpsAgent: Any? = null
)