package com.creditter.credit.application.system.service.impl

import com.creditter.credit.application.system.entities.Customer
import com.creditter.credit.application.system.exceptions.CustomException
import com.creditter.credit.application.system.repository.CustomerRepository
import com.creditter.credit.application.system.service.ICustomerService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw CustomException("Id $id not found.")
        }

    override fun delete(id: Long){
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}