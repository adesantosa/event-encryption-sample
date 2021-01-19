package com.study.andsantos.adapter.input.kafka.user

import com.study.andsantos.adapter.input.kafka.user.event.UserEvent
import com.study.andsantos.adapter.input.kafka.user.mapper.UserMapper
import com.study.andsantos.application.port.input.SaveUserUseCase
import mu.KLogger
import mu.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

private val log: KLogger = KotlinLogging.logger {}

@Component
class UserConsumer(
        private val saveUserUseCase: SaveUserUseCase,
        private val userMapper: UserMapper
) {

    @Bean
    fun userCreatedConsumer() = Consumer<UserEvent> {
        log.info ( "message received from = {$it}" )
        userConsumerEvent(it)
    }

    private fun userConsumerEvent(userEvent: UserEvent) =
            userMapper.toEncrypt(userEvent)
                    .let { saveUserUseCase.save(it) }

}