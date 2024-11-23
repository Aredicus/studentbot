package com.example.studentbot.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "USERS")
public class UserEntity {

    @Id
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USER_LOGIN")
    private String userLogin;
}


