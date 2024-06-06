package com.guhaejo.codeblack.login.controller

import com.guhaejo.codeblack.login.dto.SigninRequest
import com.guhaejo.codeblack.login.dto.SignupRequest
import com.guhaejo.codeblack.global.entity.User
import com.guhaejo.codeblack.login.repository.UserRepository
import com.guhaejo.codeblack.login.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@RestController
class UserController @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository
) {
    @PostMapping("/signup")
    fun signUpUser(@RequestBody signupRequest: SignupRequest): ResponseEntity<User> {
        val existingUser = userRepository.findByEmailId(signupRequest.email)
        if (existingUser != null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 회원입니다.")
        }

        val user = userService.signUpUser(signupRequest.email, signupRequest.password, signupRequest.phone)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @PostMapping("/signin")
    fun signInUser(@RequestBody signinRequest: SigninRequest): ResponseEntity<User?> {
        val user = userService.signInUser(signinRequest.email, signinRequest.password)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleConflict(e: ResponseStatusException): ResponseEntity<String> {
        return ResponseEntity.status(e.statusCode).body(e.reason)
    }
}
