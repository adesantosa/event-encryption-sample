package com.study.andsantos.adapter.output.aesencryption

import com.study.andsantos.application.port.output.AesEncryptionPort
import org.springframework.stereotype.Component
import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class AesEncryptionAdapter: AesEncryptionPort{

    override fun sha256(sharedSecret: ByteArray): ByteArray {
        val digest = MessageDigest.getInstance("SHA-512")
        return digest.digest(sharedSecret).copyOfRange(0, 32)
    }

    override fun encrypt(sharedPass: ByteArray, content: ByteArray): ByteArray {

        //Create random IV with AES modeGCM
        val secretKeySpec = SecretKeySpec(sharedPass, "AES")
        val iv = ByteArray(12)
        SecureRandom().nextBytes(iv)

        //Define modeCGM without Padding
        val gCMParameterSpec = GCMParameterSpec(128, iv)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")

        //Initialization
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gCMParameterSpec)
        val ciphertext = cipher.doFinal(content)

        val ivCiphertext = ByteArray(iv.size + ciphertext.size) // Concatenate IV and ciphertext (the MAC is implicitly appended to the ciphertext)
        System.arraycopy(iv, 0, ivCiphertext, 0, iv.size)
        System.arraycopy(ciphertext, 0, ivCiphertext, iv.size, ciphertext.size)

        return ivCiphertext
    }

    override fun decrypt(sharedPass: ByteArray, content: ByteArray): ByteArray {
        val secretKeySpec = SecretKeySpec(sharedPass, "AES")
        val cipherIV = content.copyOfRange(0, 12) // Separate IV
        val ciphertext = content.copyOfRange(12, content.size) // Separate ciphertext (the MAC is implicitly separated from the ciphertext)

        val gCMParameterSpec = GCMParameterSpec(128, cipherIV)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gCMParameterSpec)

        return cipher.doFinal(ciphertext)
    }
}