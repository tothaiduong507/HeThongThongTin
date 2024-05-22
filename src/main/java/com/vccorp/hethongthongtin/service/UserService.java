package com.vccorp.hethongthongtin.service;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.exception.Response;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;

import java.util.List;

public interface UserService {
    Response create(UserCreateForm form);
    Response findById(Long id);
    Response findByUserName(String userName);
    Response findByFullName(String fullName);
    Response findByAddressContaining(String address);
    Response findAllByOrderByFullNameAsc();
    Response updateUser(UserUpdateForm form, Long id);
    Response deleteById(Long id);
}
