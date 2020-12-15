package com.study.andsantos.application.domain

data class Encrypt(

        val id: Long,

        val name: String,

        val userId: String = "",

        val encryptStatusDomain: EncryptStatusDomainEnum = EncryptStatusDomainEnum.NEW

)