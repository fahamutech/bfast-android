package com.fahamutech.bfast.model

data class QueryModel<T>(
    var skip: Number? = 0,
    var size: Number? = 50,
    var orderBy: MutableList<MutableMap<String, Int>>?
    = mutableListOf(mutableMapOf(Pair("_created_at", -1))),
    var filter: FilterModel?,
    var returns: MutableList<String>? = mutableListOf(),
    var count: Boolean? = false,
    var last: Int?,
    var first: Int?,
    var id: Int?
)