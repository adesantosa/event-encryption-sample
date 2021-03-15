package com.study.andsantos.application.port.input

import com.study.andsantos.application.domain.KeyPairDomain


interface FindPublicKeyUseCase {

    fun findPublicKey() : KeyPairDomain
}