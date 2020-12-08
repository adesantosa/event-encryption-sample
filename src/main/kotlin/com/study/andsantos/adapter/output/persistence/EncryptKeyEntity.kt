package com.study.andsantos.adapter.output.persistence

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
data class EncryptKeyEntity(
        @Column
        val encryptId: Long,

        @Column
        @Enumerated(EnumType.STRING)
        val encryptStatusPersistence: EncryptStatusPersistenceEnum

) : Serializable
