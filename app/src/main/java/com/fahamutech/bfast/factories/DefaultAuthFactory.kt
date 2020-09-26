package com.fahamutech.bfast.factories

import com.fahamutech.bfast.BFastConfig
import com.fahamutech.bfast.adapters.AuthAdapter
import com.fahamutech.bfast.model.AuthOptions
import java.lang.Exception

class DefaultAuthFactory : AuthAdapter {
    override suspend fun <T : Any> authenticated(userId: String, options: AuthOptions?): T? {
        return null
    }

    override suspend fun <T> updateUser(
        id: String,
        attrs: Map<Any, Any>,
        options: AuthOptions?
    ): T {
        throw Exception("Not supported, use _User collection in your " +
                "secure env with masterKey to update user details")
    }

    override suspend fun <T> signUp(
        email: String,
        password: String,
        attrs: MutableMap<Any, Any>,
        appName: String,
        option: AuthOptions?
    ): T {
        val authRule = mutableMapOf<String, Any>()
        authRule["applicationId"] = BFastConfig.getInstance().credential(appName).applicationId
        attrs["username"] = email
        attrs["email"] = email
        attrs["password"] = password
        authRule["auth"] = mutableMapOf(Pair("signUp",attrs))
        const response = await this.restApi.post<T>(BFastConfig.getInstance().databaseURL(appName), authRule, {
            headers: {
            'x-parse-application-id': BFastConfig.getInstance().credential(appName).applicationId
        }
        });
        const data = response.data;
        if (data && data.auth && data.auth.signUp) {
            return data.auth.signUp;
        } else {
            throw {message: data.errors && data.errors.auth && data.errors['auth.signUp'] ? data.errors['auth.signUp'].message : 'Fails to signUp'};
        }
    }

    override suspend fun <T> logIn(
        username: String,
        password: String,
        appName: String,
        options: AuthOptions?
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun logOut(options: AuthOptions?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun <T> requestPasswordReset(
        email: String,
        appName: String,
        options: AuthOptions?
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun <T> requestEmailVerification(
        email: String,
        appName: String,
        options: AuthOptions?
    ): T {
        TODO("Not yet implemented")
    }

}