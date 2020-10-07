package com.fahamutech.bfast.controllers

class SecurityController {
    suspend fun <T>encrypt(data: T): T{
        return data
    }

    suspend fun <T>decrypt(data: String): Any {
        return data
    }
}