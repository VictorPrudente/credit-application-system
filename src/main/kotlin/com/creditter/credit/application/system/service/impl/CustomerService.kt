package com.creditter.credit.application.system.service.impl

import com.creditter.credit.application.system.entities.Customer
import com.creditter.credit.application.system.exceptions.CustomException
import com.creditter.credit.application.system.repository.CustomerRepository
import com.creditter.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw CustomException("Id $id not found.")
        }

    override fun deleteById(id: Long) =
        this.customerRepository.deleteById(id)
    
}