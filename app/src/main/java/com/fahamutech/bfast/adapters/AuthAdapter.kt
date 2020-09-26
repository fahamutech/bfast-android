package com.fahamutech.bfast.adapters

import com.fahamutech.bfast.model.AuthOptions

interface AuthAdapter {

    suspend fun <T: Any> authenticated(userId: String, options: AuthOptions?): T?

    suspend fun <T> updateUser(id: String, attrs: Map<Any, Any>, options: AuthOptions?): T

    suspend fun <T> signUp(
        username: String,
        password: String,
        attrs: Map<Any, Any>,
        appName: String,
        option: AuthOptions?
    ): T

    suspend fun <T> logIn(
        username: String,
        password: String,
        appName: String,
        options: AuthOptions?
    ): T

    suspend fun logOut(options: AuthOptions?): Boolean

    suspend fun <T> requestPasswordReset(email: String, appName: String, options: AuthOptions?): T
    suspend fun <T> requestEmailVerification(
        email: String,
        appName: String,
        options: AuthOptions?
    ): T
}
