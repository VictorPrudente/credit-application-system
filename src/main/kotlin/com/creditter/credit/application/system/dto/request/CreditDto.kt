package com.creditter.credit.application.system.dto.request

import com.creditter.credit.application.system.entities.Credit
import com.creditter.credit.application.system.entities.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayOfFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
)
{
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayOfFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}