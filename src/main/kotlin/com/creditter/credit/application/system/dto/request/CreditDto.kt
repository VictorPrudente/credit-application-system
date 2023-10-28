package com.creditter.credit.application.system.dto.request

import com.creditter.credit.application.system.entities.Credit
import com.creditter.credit.application.system.entities.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Input Error. Credit Value cannot be empty.")
    val creditValue: BigDecimal,
    @field:Future
    val dayOfFirstInstallment: LocalDate,
    @field:Min(value = 1)
    @field:Max(value = 48)
    val numberOfInstallments: Int,
    @field:NotNull(message = "Input Error. Customer Id cannot be empty.")
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayOfFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}