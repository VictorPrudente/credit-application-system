package com.creditter.credit.application.system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CreditSystemApplication

fun main(args: Array<String>) {
	runApplication<CreditSystemApplication>(*args)
}
