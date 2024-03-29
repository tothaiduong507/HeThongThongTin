package com.vccorp.hethongthongtin.mapper;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.entity.User;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User mapToUser(UserCreateForm form){
        var user = new User();
        user.setUserName(form.getUserName());
        user.setAge(form.getAge());
        user.setAddress(form.getAddress());
        user.setFullName(form.getFullName());
        user.setPassword(form.getPassword());
        user.setAvatar(form.getAvatar());
        return user;
    }

    public static UserDto mapToUserDto(User user){
        var userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setId(user.getId());
        userDto.setAge(user.getAge());
        userDto.setAddress(user.getAddress());
        userDto.setFullName(user.getFullName());
        userDto.setAvatar(user.getAvatar());
        return userDto;
    }

    public static List<UserDto> mapToUserDtoList(List<User> users){
        List<UserDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(mapToUserDto(user));
        }
        return dtos;
    }

    public static void updateUser(UserUpdateForm form, User user){
        user.setUserName(form.getUserName());
        user.setAge(form.getAge());
        user.setAddress(form.getAddress());
        user.setFullName(form.getFullName());
        user.setPassword(form.getPassword());
        user.setAvatar(form.getAvatar());
    }
}
