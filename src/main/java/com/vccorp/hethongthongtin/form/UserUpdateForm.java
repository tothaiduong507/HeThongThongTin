package com.vccorp.hethongthongtin.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateForm {
    @NotNull(message = "Name cannot be null.")
    @Size(min = 1, message = "Name cannot be empty.")
    private String fullName;

    @NotNull(message = "Age cannot be null.")
    @Min(value = 1, message = "Age should be at least 1.")
    @Max(value = 100, message = "Age should not exceed 100.")
    private int age;

    @NotNull(message = "Address cannot be null.")
    @Size(min = 1, message = "Address cannot be empty.")
    private String address;

    @NotNull(message = "Username cannot be null.")
    @Size(min = 1, message = "Username cannot be empty.")
    private String userName;
    private String password;
    private String avatar;
}
