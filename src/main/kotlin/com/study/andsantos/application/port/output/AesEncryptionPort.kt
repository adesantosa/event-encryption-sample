package com.study.andsantos.application.port.output

interface AesEncryptionPort {

    fun sha256(sharedSecret: ByteArray): ByteArray

    fun encrypt(sharedPass: ByteArray, content: ByteArray): ByteArray

    fun decrypt(sharedPass: ByteArray, content: ByteArray): ByteArray
}