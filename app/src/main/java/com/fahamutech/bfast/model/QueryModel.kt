package com.fahamutech.bfast.model

data class QueryModel<T>(
    var skip: Number? = 0,
    var size: Number?,
    var orderBy: MutableList<MutableMap<String, Number>>?,
    var filter: FilterModel?,
    var keys: MutableList<String>?
//    var id: String?
)