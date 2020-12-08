package com.study.andsantos.adapter.output.persistence

enum class EncryptStatusPersistenceEnum(val encryptStatusEnum: String) {
    NEW("new"),
    PENDING("pending"),
    ENCRYPTED("encrypted"),
    NOT_ENCRYPTED("not_encrypted")
}