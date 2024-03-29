package com.vccorp.hethongthongtin.controller;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;
import com.vccorp.hethongthongtin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("/api/users")
    public UserDto createUser(@RequestBody UserCreateForm form) {
        return userService.create(form);
    }


    @GetMapping("/api/users/id/{id}")
    public UserDto findByID(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/api/users/fullName/{fullName}")
    public List<UserDto> findByFullName(@PathVariable String fullName){
        return userService.findByFullName(fullName);
    }

    @GetMapping("/api/users/userName/{userName}")
    public UserDto findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/api/users/address/{address}")
    public List<UserDto> findByAddress(@PathVariable String address){
        return userService.findByAddressContaining(address);
    }

    @GetMapping("/api/users/sort/name")
    public List<UserDto> findAllByOrderByFullNameAsc(){
        return userService.findAllByOrderByFullNameAsc();
    }

    @PutMapping("/api/users/{id}")
    public UserDto updateUser(@RequestBody UserUpdateForm form, @PathVariable Long id){
        return userService.updateUser(form, id);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
