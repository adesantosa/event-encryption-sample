package com.study.andsantos.adapter.output.persistence

import com.study.andsantos.adapter.output.persistence.mapper.toEncryptDomain
import com.study.andsantos.adapter.output.persistence.mapper.toEncryptEntity
import com.study.andsantos.application.domain.Encrypt
import com.study.andsantos.application.port.output.SaveUserPersistencePort

class EncryptPersistenceAdapter(
        private val encryptRepository: EncryptRepository
) : SaveUserPersistencePort {

    override fun saveUser(encrypt: Encrypt): Encrypt =
            encrypt.toEncryptEntity()
                    .let { encryptRepository.save(it) }
                    .toEncryptDomain()
}