package com.guhaejo.codeblack.login.dto

data class SignupRequest(
    val email: String,
    val password: String,
    val phone: String
)