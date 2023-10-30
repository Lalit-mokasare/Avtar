package com.lrmd.agriculturestore.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String userId;


    @NotBlank(message = "name is Required !!!")
    private String name;

    @NotBlank(message = "Email is Required !!!")
    private String email;

    @NotBlank("")
    private String password;


    private String gender;


    private String about;


    private String imageName;


}















