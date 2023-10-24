package com.creditter.credit.application.system.service.impl

import com.creditter.credit.application.system.entities.Credit
import com.creditter.credit.application.system.repository.CreditRepository
import com.creditter.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCostumer(customerId: Long): List<Credit> {
       return  this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found."))
        if(credit.customer?.id == customerId){
            return credit
        } else {
            throw java.lang.RuntimeException("Contact admin")
        }
    }
}