package com.fahamutech.bfast.model

class FilterModel {
    var queryModel: MutableMap<String, Any> = mutableMapOf()

    fun equalTo(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$eq", value)
        )
        return this
    }

    fun greaterThan(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$gt", value)
        )
        return this
    }

    fun greaterThanOrEqualTo(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$gte", value)
        )
        return this
    }

    fun includedIn(column: Any, value: MutableList<Any>): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$in", value)
        )
        return this
    }

    fun notIncludedIn(column: Any, value: MutableList<Any>): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$nin", value)
        )
        return this
    }

    fun lessThan(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$lt", value)
        )
        return this
    }

    fun notEqualTo(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$ne", value)
        )
        return this
    }

    fun lessThanOrEqualTo(column: Any, value: Any): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$lte", value)
        )
        return this
    }

    fun exists(column: Any, value: Boolean = true): FilterModel {
        this.queryModel[column as String] = mutableMapOf(
            Pair("\$exists", value)
        )
        return this
    }

}
