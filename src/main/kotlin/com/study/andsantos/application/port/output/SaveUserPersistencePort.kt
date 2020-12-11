package com.study.andsantos.application.port.output

import com.study.andsantos.application.domain.Encrypt

interface SaveUserPersistencePort {

    fun saveUser(encrypt: Encrypt) : Encrypt
}