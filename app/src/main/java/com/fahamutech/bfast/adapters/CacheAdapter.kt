package com.fahamutech.bfast.adapters

interface CacheAdapter {
    suspend fun <T> set(
        identifier: String,
        data: T,
        database: String,
        collection: String,
        dtl: Int?
    ): T

    suspend fun <T> get(identifier: String, database: String, collection: String): T

    suspend fun keys(database: String, collection: String): List<String>?

    suspend fun clearAll(database: String, collection: String): Boolean

    suspend fun remove(
        identifier: String,
        database: String,
        collection: String,
        force: Boolean?
    ): Boolean

    suspend fun cacheEnabled(appName: String): Boolean
}