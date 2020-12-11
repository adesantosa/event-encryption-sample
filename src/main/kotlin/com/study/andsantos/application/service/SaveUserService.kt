package com.study.andsantos.application.service

import com.study.andsantos.application.domain.Encrypt
import com.study.andsantos.application.port.input.SaveUserUseCase
import com.study.andsantos.application.port.output.SaveUserPersistencePort

class SaveUserService(
        private val saveUserPersistencePort: SaveUserPersistencePort
) : SaveUserUseCase {

    override fun save(encrypt: Encrypt) =
            saveUserPersistencePort.saveUser(encrypt)
}