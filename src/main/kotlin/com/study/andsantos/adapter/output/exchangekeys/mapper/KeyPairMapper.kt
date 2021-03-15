package com.study.andsantos.adapter.output.exchangekeys.mapper

import com.study.andsantos.application.domain.KeyPairDomain
import java.security.KeyFactory
import java.security.KeyPair
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.*

fun KeyPair.toDomain() = KeyPairDomain(
    privateKey = Base64.getEncoder().encodeToString(this.private.encoded),
    publicKey = Base64.getEncoder().encodeToString(this.public.encoded)
)

//fun KeyPairDomain.fromDomain() = java.security.KeyPair(
//    privateKey = Base64.getDecoder().decode(privateKey)
//)
//    val privateKey = Base64.getEncoder().encodeToString(publicKey)
//    val publicKey = Base64.getEncoder().encodeToString(public.encoded)
//
//    val private = private.getPrivateKey(privateKey)
//    val public = public.getPublicKey(publicKey)
//
//    return java.security.KeyPair(public, private)
//}

fun PrivateKey.getPrivateKey(privateKeyString: String): PrivateKey{
    val privateKey = Base64.getDecoder().decode(privateKeyString)

    val keyFactory = KeyFactory.getInstance("DiffieHellman")
    val getPrivateKey = PKCS8EncodedKeySpec(privateKey)

    return keyFactory.generatePrivate(getPrivateKey)
}

fun PublicKey.getPublicKey(publicKeyString: String): PublicKey{
    val publicKey = Base64.getDecoder().decode(publicKeyString)

    val keyFactory = KeyFactory.getInstance("DiffieHellman")
    val getPublicKey = X509EncodedKeySpec(publicKey)

    return keyFactory.generatePublic(getPublicKey)
}

//fun toPrivateKey() = PrivateKey(
//    Base64.getEncoder().encodeToString()
//)


//fun getPKCS8(privateKey: String) =
//    PKCS8EncodedKeySpec(fromDomainPrivateKey(privateKey))