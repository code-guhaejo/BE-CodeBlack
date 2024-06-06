package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "chat")
data class Chat(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val chatId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    val userId: User,

    val chatDate: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_category", referencedColumnName = "category", nullable = false)
    val hospitalCategory: HospitalCategory
)