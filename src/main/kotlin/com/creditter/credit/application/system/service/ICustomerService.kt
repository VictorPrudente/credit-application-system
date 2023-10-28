package com.creditter.credit.application.system.service

import com.creditter.credit.application.system.entities.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)

}