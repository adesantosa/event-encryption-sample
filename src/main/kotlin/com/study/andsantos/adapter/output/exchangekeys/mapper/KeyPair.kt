package com.study.andsantos.adapter.output.exchangekeys.mapper

import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.util.*

class KeyPair {

    fun fromDomainPrivateKey(privateKey: String) =
        Base64.getDecoder().decode(privateKey)

    fun fromDomainPublicKey(publicKey: String) =
        Base64.getDecoder().decode(publicKey)

    fun getPKCS8(privateKey: String) =
        PKCS8EncodedKeySpec(fromDomainPrivateKey(privateKey))
}