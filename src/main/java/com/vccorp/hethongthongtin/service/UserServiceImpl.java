package com.vccorp.hethongthongtin.service;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.entity.User;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;
import com.vccorp.hethongthongtin.mapper.UserMapper;
import com.vccorp.hethongthongtin.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.mapToUser(form);
        var savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto findById(Long id) {
        var user = userRepository.findById(id).get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto findByUserName(String userName) {
        var user = userRepository.findByUserName(userName);
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> findByFullName(String fullName) {
        List<User> users = userRepository.findByFullName(fullName);
        List<UserDto> dtos = UserMapper.mapToUserDtoList(users);
        return dtos;
    }

    @Override
    public List<UserDto> findByAddressContaining(String address) {
        List<User> users = userRepository.findByAddressContaining(address);
        List<UserDto> dtos = UserMapper.mapToUserDtoList(users);
        return dtos;
    }

    @Override
    public List<UserDto> findAllByOrderByFullNameAsc() {
        List<User> users = userRepository.findAllByOrderByFullNameAsc();
        List<UserDto> dtos = UserMapper.mapToUserDtoList(users);
        return dtos;
    }

    @Override
    public UserDto updateUser(UserUpdateForm form, Long id) {
        var user = userRepository.findById(id).get();
        UserMapper.updateUser(form, user);
        var saveUser = userRepository.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
