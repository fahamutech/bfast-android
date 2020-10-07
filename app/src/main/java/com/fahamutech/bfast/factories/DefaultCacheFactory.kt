package com.fahamutech.bfast.factories

import com.fahamutech.bfast.BFastConfig
import com.fahamutech.bfast.adapters.CacheAdapter
import com.fahamutech.bfast.controllers.SecurityController
import java.util.*


class DefaultCacheFactory(private val securityController: SecurityController): CacheAdapter {

//    private fun _getCacheDatabase(database: String, collection: String): Any {
//
//    }

    override suspend fun <T> set(
        identifier: String,
        data: T,
        database: String,
        collection: String,
        dtl: Int?
    ): T {
        TODO("Not yet implemented")
    }

    override suspend fun <T> get(identifier: String, database: String, collection: String): T {
        TODO("Not yet implemented")
    }

    override suspend fun keys(database: String, collection: String): List<String>?{
        return null
    }

    override suspend fun clearAll(database: String, collection: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun remove(
        identifier: String,
        database: String,
        collection: String,
        force: Boolean?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun cacheEnabled(appName: String): Boolean {
        return false
    }


    private fun _getDayToLeave(days: Int) {
        val date = Date()
        return date.setTime(date.time + (days * 24 * 60 * 60 * 1000));
    }


//    override fun cacheEnabled(appName: String, options: RequestOptions?): Boolean {
//        if (options && options.cacheEnable !== null) {
//            return options.cacheEnable;
//        } else {
//            return BFastConfig.getInstance().credential(appName)?.cache?.enable === true
//        }
//    }
}
