package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "user_profile")
data class UserProfile(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userProfileId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    val userId: User,

    val userName: String,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    val birth: LocalDateTime,
    val weight: Double,
    val height: Double,

    @Enumerated(EnumType.STRING)
    val bloodType: BloodType,

    val allergy: String
) {
    enum class Gender { MALE, FEMALE, NON_BINARY, OTHER }
    enum class BloodType { A_PLUS, A_MINUS, B_PLUS, B_MINUS, AB_PLUS, AB_MINUS, O_PLUS, O_MINUS }
}