package com.study.andsantos.adapter.output.persistence.mapper

import com.study.andsantos.adapter.output.persistence.EncryptEntity
import com.study.andsantos.adapter.output.persistence.EncryptKeyEntity
import com.study.andsantos.adapter.output.persistence.EncryptStatusPersistenceEnum
import com.study.andsantos.application.domain.Encrypt

class EncryptPersistenceMapper {

    fun toEncryptEntity(encrypt: Encrypt) = EncryptEntity(
            id = EncryptKeyEntity(
                    encryptId = encrypt.id,
                    encryptStatusPersistence =
                    EncryptStatusPersistenceEnum.valueOf(encrypt.encryptStatusDomain.name)),
            userId = encrypt.userId,
            name = encrypt.name
    )

}
