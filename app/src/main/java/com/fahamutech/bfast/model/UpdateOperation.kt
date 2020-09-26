package com.fahamutech.bfast.model

data class UpdateOperation(var column: String) {
    fun increment(amount: Number = 0): MutableMap<String, Any> {
        return mutableMapOf(
            Pair(
                this.column,
                mutableMapOf(
                    Pair("__op", "Increment"),
                    Pair("amount", amount)
                )
            )
        )
    }

    fun addItems(items: MutableList<Any> = mutableListOf()): MutableMap<String, Any> {
        return mutableMapOf(
            Pair(
                this.column,
                mutableMapOf(
                    Pair("__op", "Add"),
                    Pair("objects", items)
                )
            )
        )
    }

    fun removeItems(items: MutableList<Any> = mutableListOf()): MutableMap<String, Any> {
        return mutableMapOf(
            Pair(
                this.column,
                mutableMapOf(
                    Pair("__op", "Remove"),
                    Pair("objects", items)
                )
            )
        )
    }

    fun addUniqueItems(items: MutableList<Any> = mutableListOf()): MutableMap<String, Any> {
        return mutableMapOf(
            Pair(
                this.column,
                mutableMapOf(
                    Pair("__op", "AddUnique"),
                    Pair("objects", items)
                )
            )
        )
    }

    fun addNumber(number: Number): MutableMap<String, Number> {
        return mutableMapOf(
            Pair(
                this.column,
                number
            )
        )
    }

    fun addString(string: String): MutableMap<String, String> {
        return mutableMapOf(
            Pair(
                this.column,
                string
            )
        )
    }

    fun addMap(map: MutableMap<Any, Any>): MutableMap<String, MutableMap<Any, Any>> {
        return mutableMapOf(
            Pair(
                this.column,
                map
            )
        )
    }

//    fun addRelation(items: MutableList<MutableMap<String,Any>> = mutableListOf()): MutableMap<String, Any>{
//        return mutableMapOf(
//            Pair("__op", "AddRelation"),
//            Pair("objects", mutableListOf(Pair("__type","Pointer"), Pair("className","objectId")))
//        )
//    }
}