package com.study.andsantos.application.service

import com.study.andsantos.application.domain.Encrypt
import com.study.andsantos.application.port.input.SaveUserUseCase
import com.study.andsantos.application.port.output.SaveUserPersistencePort
import org.springframework.stereotype.Service

@Service
class SaveUserService(
        private val saveUserPersistencePort: SaveUserPersistencePort
) : SaveUserUseCase {

    override fun save(encrypt: Encrypt) =
            saveUserPersistencePort.saveUser(encrypt)
}