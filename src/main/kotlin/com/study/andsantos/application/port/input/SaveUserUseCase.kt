package com.study.andsantos.application.port.input

import com.study.andsantos.application.domain.Encrypt

interface SaveUserUseCase {

    fun save(encrypt: Encrypt) : Encrypt
}