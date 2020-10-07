package com.fahamutech.bfast.model

data class DatabaseChangesModel(
    val info: String,
    val error: String,
    var change: DatabaseChange
)

data class DatabaseChange(
    val name: DatabaseChangesType,
    val resumeToken: DatabaseChangeResumeToken,
    val snapshot: MutableMap<Any, Any>
)

data class DatabaseChangeResumeToken(
    val _id: String
)
enum class DatabaseChangesType{
    CREATE,
    UPDATE,
    DELETE
}
