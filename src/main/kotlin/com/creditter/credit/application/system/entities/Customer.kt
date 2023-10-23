package com.creditter.credit.application.system.entities

data class Customer(
    var firstName: String = "",
    var lastName: String = "",
    val cpf: String,
    var email: String = "",
    var password: String = "",
    var adress: Address = Address(),
    var credits: List<Credit> = mutableListOf(),
    var id: Long? = null
)
