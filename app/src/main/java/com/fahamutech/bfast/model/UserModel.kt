package com.fahamutech.bfast.model

data class UserModel(
    var id: String?,
    var createdAt: Any?,
    var updatedAt: Any?,
    var token: String?,
    var username: String?,
    var password: String?,
    var email: String?,
    var vararg: MutableMap<String, Any>? = mutableMapOf()
)
