package com.creditter.credit.application.system.entities

import com.creditter.credit.application.system.enums.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID


@Entity
@Table(name = "Credit")
data class Credit(
    @Column (nullable = false, unique = true) var creditCode: UUID = UUID.randomUUID(),
    @Column (nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column (nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null

)