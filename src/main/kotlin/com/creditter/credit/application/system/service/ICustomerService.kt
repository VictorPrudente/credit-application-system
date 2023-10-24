package com.creditter.credit.application.system.service

import com.creditter.credit.application.system.entities.Credit
import java.util.UUID

interface ICustomerService {

    fun save(credit: Credit): Credit
    fun findAllByCostumer(customerId: Long): List<Credit>
    fun findByCreditCode(creditCode: UUID): Credit
}