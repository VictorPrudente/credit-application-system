package com.creditter.credit.application.system.dto

import com.creditter.credit.application.system.entities.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.adress.zipCode = this.zipCode
        customer.adress.street = this.street
        return customer
    }
}
