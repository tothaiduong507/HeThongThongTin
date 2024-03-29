package com.vccorp.hethongthongtin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name", length = 20, nullable = false)
    private String fullName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "username", length = 20, unique = true, nullable = false)
    private String userName;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "avatar", length = 50)
    private String avatar;
}
