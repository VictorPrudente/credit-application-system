package com.creditter.credit.application.system.dto.response

import com.creditter.credit.application.system.entities.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberofInstallment: Int
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberofInstallment = credit.numberOfInstallments
    )
}
