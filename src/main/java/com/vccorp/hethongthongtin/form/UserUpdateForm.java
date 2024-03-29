package com.vccorp.hethongthongtin.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateForm {
    private String fullName;
    private int age;
    private String address;
    private String userName;
    private String password;
    private String avatar;
}
