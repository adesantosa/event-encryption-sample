package com.study.andsantos.adapter.input.web

import com.study.andsantos.application.domain.KeyPairDomain
import com.study.andsantos.application.service.FindPublicKeyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EncryptionController(
    private val findPublicKeyService: FindPublicKeyService
) {

    @GetMapping("/public-key")
    fun findPublicKey(): String =
        findPublicKeyService.findPublicKey().publicKey
}
