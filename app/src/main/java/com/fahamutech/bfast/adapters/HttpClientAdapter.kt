package com.fahamutech.bfast.adapters

import com.fahamutech.bfast.model.RestRequestConfig
import com.fahamutech.bfast.model.RestResponse

interface HttpClientAdapter {
    suspend fun <T : Any, R : RestResponse<T>> get(
        url: String,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> delete(
        url: String,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> head(
        url: String,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> options(
        url: String,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> post(
        url: String,
        data: Any? = null,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> put(
        url: String,
        data: Any? = null,
        config: RestRequestConfig? = null
    ): R

    suspend fun <T : Any, R : RestResponse<T>> patch(
        url: String,
        data: Any? = null,
        config: RestRequestConfig? = null
    ): R
}
