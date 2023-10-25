package com.creditter.credit.application.system.controller

import com.creditter.credit.application.system.dto.CustomerDTO
import com.creditter.credit.application.system.dto.CustomerUpdateDto
import com.creditter.credit.application.system.dto.CustomerView
import com.creditter.credit.application.system.entities.Customer
import com.creditter.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO): String {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomerByID(@PathVariable id: Long) {
        return this.customerService.deleteById(id)
    }

    @PatchMapping("/{id}")
    fun updateCustomerById(@PathVariable id: Long, @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }

}