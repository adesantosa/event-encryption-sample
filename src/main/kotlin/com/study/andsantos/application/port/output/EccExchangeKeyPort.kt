package com.study.andsantos.application.port.output


import com.study.andsantos.application.domain.KeyPairDomain
import java.security.PrivateKey
import java.security.PublicKey

interface EccExchangeKeyPort {

    fun generateKeyPair() : KeyPairDomain

    fun getSharedSecret(privateKey : PrivateKey, publicKey: PublicKey) : ByteArray

}