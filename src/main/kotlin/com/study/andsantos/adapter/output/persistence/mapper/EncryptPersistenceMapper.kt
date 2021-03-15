package com.study.andsantos.adapter.output.persistence.mapper

import com.study.andsantos.adapter.output.persistence.entity.EncryptEntity
import com.study.andsantos.adapter.output.persistence.entity.EncryptKeyEntity
import com.study.andsantos.adapter.output.persistence.entity.EncryptStatusPersistenceEnum
import com.study.andsantos.application.domain.Encrypt
import com.study.andsantos.application.domain.EncryptStatusDomainEnum


fun Encrypt.toEncryptEntity() = EncryptEntity(
        id = EncryptKeyEntity(
                encryptId = this.id,
                encryptStatusPersistence =
                EncryptStatusPersistenceEnum.valueOf(this.encryptStatusDomain.name)),
        name = this.name
)

fun EncryptEntity.toEncryptDomain() = Encrypt(
        id = this.id.encryptId,
        name = this.name,
        encryptStatusDomain = EncryptStatusDomainEnum.valueOf(this.id.encryptStatusPersistence.name)
)

