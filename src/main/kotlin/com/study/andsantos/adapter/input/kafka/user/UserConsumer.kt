package com.study.andsantos.adapter.input.kafka.user

import com.study.andsantos.adapter.input.kafka.user.event.UserEvent
import com.study.andsantos.adapter.input.kafka.user.mapper.UserMapper
import com.study.andsantos.application.port.input.SaveUserUseCase
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class UserConsumer(
        private val saveUserUseCase: SaveUserUseCase,
        private val userMapper: UserMapper
) {

    @Bean
    fun consumerUser() = Consumer<UserEvent> {
        consumerUserEvent(it)
    }

    private fun consumerUserEvent(userEvent: UserEvent) =
            userMapper.toEncrypt(userEvent)
                    .let { saveUserUseCase.save(it) }

}