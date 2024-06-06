package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*

@Entity
@Table(name = "hospital")
data class Hospital(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val hospitalId: Int,

    val hospitalName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_category", referencedColumnName = "category", nullable = false)
    val hospitalCategory: HospitalCategory,

    val hospitalAddress: String,
    val hospitalTel: String,
    val operatingTime: String,
    val mcdpCd: String
)