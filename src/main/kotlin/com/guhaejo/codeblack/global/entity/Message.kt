package com.guhaejo.codeblack.global.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "message")
data class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val messageId: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", referencedColumnName = "chatId", nullable = false)
    val chatId: Chat,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    val userId: User,

    @Enumerated(EnumType.STRING)
    val sender: Sender,

    val messageDate: LocalDateTime,

    @Lob
    @Column(columnDefinition = "TEXT")
    val message: String
) {
    enum class Sender { USER, AI }
}
