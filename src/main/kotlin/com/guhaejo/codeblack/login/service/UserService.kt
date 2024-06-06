package com.guhaejo.codeblack.login.service

import com.guhaejo.codeblack.global.entity.User
import com.guhaejo.codeblack.login.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun signUpUser(email: String, password: String, phone: String): User? {
        val user = User(emailId = email, userPassword = password, userPhone = phone)
        return userRepository.save(user)
    }

    fun signInUser(email: String, password: String): User? {
        val user = userRepository.findByEmailId(email) ?: return null
        if (user.userPassword == password) {
            return user
        }
        return null
    }
}
