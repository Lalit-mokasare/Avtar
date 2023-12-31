package com.lrmd.agriculturestore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {


    @Id
    private String userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password", length = 20)
    private String password;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_about", length = 1000)
    private String about;

    @Column(name = "user_imageName")
    private String imageName;


}
