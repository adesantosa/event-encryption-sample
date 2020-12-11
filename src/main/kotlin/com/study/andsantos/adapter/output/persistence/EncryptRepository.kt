package com.study.andsantos.adapter.output.persistence

import com.study.andsantos.adapter.output.persistence.entity.EncryptEntity
import com.study.andsantos.adapter.output.persistence.entity.EncryptKeyEntity
import org.springframework.data.repository.CrudRepository

interface EncryptRepository : CrudRepository<EncryptEntity, EncryptKeyEntity> {
}