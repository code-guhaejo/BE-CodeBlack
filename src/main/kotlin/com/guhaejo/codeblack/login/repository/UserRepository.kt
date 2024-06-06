package com.guhaejo.codeblack.login.repository

import com.guhaejo.codeblack.global.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmailId(emailId: String): User?
}