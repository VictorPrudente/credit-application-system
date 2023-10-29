package com.creditter.credit.application.system.controller

import com.creditter.credit.application.system.dto.request.CustomerDto
import com.creditter.credit.application.system.dto.request.CustomerUpdateDto
import com.creditter.credit.application.system.dto.response.CustomerView
import com.creditter.credit.application.system.entities.Customer
import com.creditter.credit.application.system.service.impl.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody @Valid customerDTO: CustomerDto): ResponseEntity<CustomerView> {
        val savedCustomer: Customer = this.customerService.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerView((savedCustomer)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomerByID(@PathVariable id: Long) {
        return this.customerService.delete(id)
    }

    @PatchMapping("/{id}")
    fun updateCustomerById(
        @PathVariable id: Long,
        @RequestBody @Valid customerUpdateDto: CustomerUpdateDto
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }

}