package com.study.andsantos.adapter.output.exchangekeys

import com.study.andsantos.adapter.output.exchangekeys.mapper.getPrivateKey
import com.study.andsantos.adapter.output.exchangekeys.mapper.toDomain
import com.study.andsantos.application.domain.KeyPairDomain
import com.study.andsantos.application.port.output.EccExchangeKeyPort
import org.springframework.stereotype.Component
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.ECGenParameterSpec
import javax.crypto.KeyAgreement


@Component
class EccKeyExchangeAdapter : EccExchangeKeyPort {

    override fun generateKeyPair(): KeyPairDomain {
        val keyPairGenerator = KeyPairGenerator.getInstance("EC")
        keyPairGenerator.initialize(ECGenParameterSpec("secp521r1"))
        val generateKeyPair = keyPairGenerator.generateKeyPair()
        return generateKeyPair.toDomain()
    }


    override fun getSharedSecret(privateKey: PrivateKey, publicKey: PublicKey): ByteArray {
        val keyAgreement = KeyAgreement.getInstance("ECDH")
        keyAgreement.init(privateKey)
        keyAgreement.doPhase(publicKey, true)
        return keyAgreement.generateSecret()
    }

}