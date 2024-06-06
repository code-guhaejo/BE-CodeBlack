package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*

@Entity
@Table(name = "hospital_category")
data class HospitalCategory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryId: Int,

    @Column(unique = true)
    val category: String
)