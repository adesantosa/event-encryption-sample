package com.study.andsantos.adapter.input.kafka.user.mapper

import com.study.andsantos.adapter.input.kafka.user.event.UserEvent
import com.study.andsantos.application.domain.Encrypt
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUserEvent(event: Encrypt) = UserEvent(
            id = event.id,
            name = event.name
    )

    fun toEncrypt(userEvent: UserEvent) = Encrypt(
            id = userEvent.id,
            name = userEvent.name
    )

}