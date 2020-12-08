package com.study.andsantos.adapter.output.persistence

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
        val userId: String,

        @Column
        val name: String

)
