package com.example.studentbot.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ChatEntity {
    @Id
    @Column(name = "CHAT_ID")
    private Long chatId;
}
