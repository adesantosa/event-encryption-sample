package com.study.andsantos.application.service

import com.study.andsantos.application.port.input.FindPublicKeyUseCase
import com.study.andsantos.application.port.output.EccExchangeKeyPort
import org.springframework.stereotype.Service


@Service
class FindPublicKeyService(
    private val eccExchangeKeyPort: EccExchangeKeyPort
) : FindPublicKeyUseCase {

    override fun findPublicKey() =
        eccExchangeKeyPort.generateKeyPair()

}