package com.vccorp.hethongthongtin.service;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;

import java.util.List;

public interface UserService {
    UserDto create(UserCreateForm form);
    UserDto findById(Long id);
    UserDto findByUserName(String userName);
    List<UserDto> findByFullName(String fullName);
    List<UserDto> findByAddressContaining(String address);
    List<UserDto> findAllByOrderByFullNameAsc();
    UserDto updateUser(UserUpdateForm form, Long id);
    void deleteById(Long id);
}
