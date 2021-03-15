package com.study.andsantos.application.domain

data class Encrypt(

        val id: Long,

        val name: String,
        
        val encryptStatusDomain: EncryptStatusDomainEnum = EncryptStatusDomainEnum.NEW

)