package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int = 0,

    @Column(unique = true)
    val emailId: String,

    @Column(unique = true)
    val userPassword: String,

    @Column(unique = true)
    val userPhone: String
)