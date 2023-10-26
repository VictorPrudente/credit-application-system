package com.creditter.credit.application.system.dto.request

import com.creditter.credit.application.system.entities.Address
import com.creditter.credit.application.system.entities.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Input Error. Name field cannot be empty.")
    val firstName: String,
    @field:NotEmpty(message = "Input Error. Last name field cannot be empty.")
    val lastName: String,
    @field:NotEmpty(message = "Input Error. Cpf cannot be empty.")
    @field:CPF(message = "This is not a valid CPF.")
    val cpf: String,
    @field:NotNull(message = "Input Error. Income cannot be empty.")
    val income: BigDecimal,
    @field:NotEmpty(message = "Input Error. Email cannot be empty.")
    @field:Email(message = "This is not a valid email..")
    val email: String,
    @field:NotEmpty(message = "Input Error. Password cannot be empty.")
    val password: String,
    @field:NotEmpty(message = "Input Error. Zip code cannot be empty.")
    val zipcode: String,
    @field:NotEmpty(message = "Input Error. Street cannot be empty.")
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        adress = Address(
            zipCode = this.zipcode,
            street = this.street
        )
    )
}
