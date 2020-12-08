package com.study.andsantos.application.domain

enum class EncryptStatusDomainEnum(val encryptStatusEnum: String) {
    NEW("new"),
    PENDING("pending"),
    ENCRYPTED("encrypted"),
    NOT_ENCRYPTED("not_encrypted")
}