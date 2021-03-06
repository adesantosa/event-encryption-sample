package com.study.andsantos.adapter.input.kafka.user

import com.study.andsantos.integration.IntegrationTests
import com.study.andsantos.adapter.output.persistence.EncryptRepository
import com.study.andsantos.integration.consumer.UserConsumerEvent
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserConsumerTest(
    @Autowired
    private val userConsumerEvent: UserConsumerEvent,
    @Autowired
    private val encryptRepository: EncryptRepository
) : IntegrationTests() {

    @Test
    fun `Should consumer an event and save it`() {
        //Arrange
        val event = userConsumerEvent.build()
        //Act
        userConsumerEvent.consumerEvent(event)
        //Assert
        encryptRepository.findAll()
    }
}