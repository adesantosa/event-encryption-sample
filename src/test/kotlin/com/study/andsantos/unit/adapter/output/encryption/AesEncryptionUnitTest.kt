package com.study.andsantos.unit.adapter.output.encryption



import com.study.andsantos.adapter.output.aesencryption.AesEncryptionAdapter
import com.study.andsantos.adapter.output.exchangekeys.EccKeyExchangeAdapter
import com.study.andsantos.adapter.output.exchangekeys.mapper.getPrivateKey
import com.study.andsantos.adapter.output.exchangekeys.mapper.getPublicKey
import com.study.andsantos.unit.UnitTest
import kotlinx.coroutines.channels.ticker
import org.bouncycastle.asn1.x509.Extension
import org.junit.jupiter.api.Test
import java.nio.charset.StandardCharsets
import java.security.PrivateKey
import java.security.PublicKey

class AesEncryptionUnitTest : UnitTest() {

    private val aesEncryptionAdapter = AesEncryptionAdapter()
    private val eccExchangeKeyAdapter = EccKeyExchangeAdapter()
    private val privateKey: PrivateKey by lazy{ privateKey }
    private val publicKey: PublicKey by lazy{ publicKey }

    @Test
    fun `should encrypt and decrypt any data with Ecc exchange`() {

        //Generate keys
        val keyA = eccExchangeKeyAdapter.generateKeyPair()
        val keyB = eccExchangeKeyAdapter.generateKeyPair()


//        //Create primary and public keys
//        val sharedsA = eccExchangeKeyAdapter
//            .getSharedSecret(privateKey.getPrivateKey(keyA.privateKey), publicKey.getPublicKey(keyB.publicKey))
//        val sharedsB = eccExchangeKeyAdapter
//            .getSharedSecret(privateKey.getPrivateKey(keyB.privateKey), publicKey.getPublicKey(keyA.publicKey))
//
//        //Applying SHA-512
//        val sha256A = aesEncryptionAdapter.sha256(sharedsA)
//        val sha256B = aesEncryptionAdapter.sha256(sharedsB)
//
//        //Generate bytearray of content
//        val content = "Masha é um desenho do capeta!!!!".toByteArray(StandardCharsets.UTF_8)
//        print("{Content} = $content")
//
//        //Encrypt data
//        val encrypt = aesEncryptionAdapter.encrypt(sha256A, content)
//        print("Encrypt output = $encrypt")
//
//        //Decrypt data
//        val decrypt = aesEncryptionAdapter.decrypt(sha256B, encrypt)
//        print(String(decrypt, StandardCharsets.UTF_8))

    }
}