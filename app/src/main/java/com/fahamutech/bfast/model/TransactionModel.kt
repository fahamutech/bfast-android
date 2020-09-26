package com.fahamutech.bfast.model

data class TransactionModel(
    var method: String,
    var path: String,
    var body: MutableMap<Any, Any>
)

enum class TransactionMethod {
    PUT,
    DELETE,
    POST
}