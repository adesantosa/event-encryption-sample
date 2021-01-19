package com.study.andsantos.consumer

import com.github.javafaker.Faker
import com.study.andsantos.adapter.input.kafka.user.UserConsumer
import com.study.andsantos.adapter.input.kafka.user.event.UserEvent
import org.springframework.stereotype.Component

@Component
class UserConsumerEvent(
    private val userConsumer: UserConsumer
) {

    fun consumerEvent(userEvent: UserEvent) : UserEvent {
        val event = UserEvent(
            id = userEvent.id,
            name = userEvent.name
        )
        userConsumer.userCreatedConsumer().accept(event)
        return event
    }

    fun build() = UserEvent (
        id = System.nanoTime(),
        name = Faker.instance().funnyName().name()
    )
}