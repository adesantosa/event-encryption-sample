package com.study.andsantos.adapter.output.persistence.entity

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "encrypt")
data class EncryptEntity(
    @EmbeddedId
        val id: EncryptKeyEntity,

    @Column
        val name: String

)
