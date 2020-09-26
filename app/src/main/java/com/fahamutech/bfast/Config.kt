package com.fahamutech.bfast

import com.fahamutech.bfast.adapters.AuthAdapter
import com.fahamutech.bfast.adapters.CacheAdapter
import com.fahamutech.bfast.adapters.HttpClientAdapter
import com.fahamutech.bfast.factories.DefaultAuthFactory

object BFastConfig {
    val DEFAULT_APP = "DEFAULT"
    private val _DEFAULT_DOMAINS_CACHE_DB_NAME = "__domain";

    fun DEFAULT_DOMAINS_CACHE_DB_NAME(): String {
        return this._DEFAULT_DOMAINS_CACHE_DB_NAME
    }

    private val _DEFAULT_AUTH_CACHE_DB_NAME = "__auth"

    fun DEFAULT_AUTH_CACHE_DB_NAME(): String {
        return this._DEFAULT_AUTH_CACHE_DB_NAME
    }

    private val _DEFAULT_CACHE_DB_NAME = "__cache"

    fun DEFAULT_CACHE_DB_NAME(): String {
        return this._DEFAULT_CACHE_DB_NAME
    }

    private val _DEFAULT_CACHE_TTL_COLLECTION_NAME = "__cache_ttl"

    fun DEFAULT_CACHE_TTL_COLLECTION_NAME(): String {
        return this._DEFAULT_CACHE_TTL_COLLECTION_NAME
    }

    private val credentials: MutableMap<String, AppCredentials> = mutableMapOf()


    fun getInstance(): BFastConfig {
        return this
    }

    fun setCredential(config: AppCredentials, appName: String = DEFAULT_APP) {
        BFastConfig.credentials[appName] = config
    }

    fun credential(appName: String = DEFAULT_APP): AppCredentials? {
        if (this.credentials[appName] === null) {
            throw Error("The app -> $appName is not initialized")
        }
        return this.credentials[appName]
    }

    fun functionsURL(path: String, appName: String): String {
        if (path.startsWith("http")) {
            return path
        }
        if (this.credentials[appName]!!.functionsURL != null && this.credentials[appName]!!.functionsURL!!.startsWith(
                "http"
            )
        ) {
            return "${this.credentials[appName]!!.functionsURL}${path}"
        }
        return "https://${this.credentials[appName]!!.projectId}-faas.bfast.fahamutech.com${path}"
    }

    fun databaseURL(appName: String, suffix: String = "/v2"): String? {
        if (this.credentials[appName]!!.databaseURL != null && this.credentials[appName]!!.databaseURL!!.startsWith(
                "http"
            )
        ) {
            return this.credentials[appName]!!.databaseURL
        }
        return "https://${this.credential(appName)!!.projectId}-daas.bfast.fahamutech.com${suffix}"

    };

    fun cacheDatabaseName(name: String?, appName: String): String {
        return if (name != null && name.isNotEmpty()) {
            "bfast/${this.credential(appName)!!.projectId}/${appName}/${name}"
        } else {
            "bfast/${this.credential(appName)!!.projectId}/${appName}"
        }
    }

    fun cacheCollectionName(name: String?, appName: String): String {
        return if (name != null && name.isNotEmpty()) {
            "${name}/${appName}"
        } else {
            "cache/${appName}"
        }
    }

    fun authAdapter(appName: String): AuthAdapter {
        val adapters = this.credential(appName)?.adapters
        return if (adapters?.auth != null) {
            adapters.auth()
        } else {
            DefaultAuthFactory()
        }
    }

    fun cacheAdapter(appName: String): CacheAdapter {
        val adapters = this.credential(appName)?.adapters
        return if (adapters?.cache != null) {
            adapters.cache()
        } else {
            DefaultCacheFactory()
        }
    }

    fun httpAdapter(appName: String): HttpClientAdapter? {
        val adapters = this.credential(appName)?.adapters
        return if (adapters?.http != null) {
            adapters.http()
        } else {
            null
        }
    }
}

data class AppCredentials(
    var applicationId: String? = null,
    var functionsURL: String? = null,
    var projectId: String? = null,
    var databaseURL: String? = null,
    var appPassword: String? = null,
    var cache: CacheConfigOptions? = null,
    var adapters: BFastAdapters? = null
)

data class BFastAdapters(
    var auth: () -> AuthAdapter,
    var cache: () -> CacheAdapter,
    var http: () -> HttpClientAdapter
)

data class CacheConfigOptions(
    var enable: Boolean = false,
    var collection: String? = null,
    var ttlCollection: String? = null
)
