package com.example.studentbot.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class VisitsEntity {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "CHAT_ID")
    private Long chatId;
}
