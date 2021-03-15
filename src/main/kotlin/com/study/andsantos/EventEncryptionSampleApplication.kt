package com.study.andsantos

import com.study.andsantos.adapter.output.aesencryption.AesEncryptionAdapter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.nio.charset.StandardCharsets

@SpringBootApplication
class EventEncryptionSampleApplication

fun main(args: Array<String>) {
	runApplication<EventEncryptionSampleApplication>(*args)
}
