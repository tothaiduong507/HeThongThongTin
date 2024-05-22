package com.vccorp.hethongthongtin.controller;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;
import com.vccorp.hethongthongtin.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("/api/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateForm form, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(form));
    }

    @GetMapping("/api/users/id/{id}")
    public ResponseEntity<?> findByID(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/api/users/fullName/{fullName}")
    public ResponseEntity<?> findByFullName(@PathVariable String fullName){
        return ResponseEntity.ok(userService.findByFullName(fullName)) ;
    }

    @GetMapping("/api/users/userName/{userName}")
    public ResponseEntity<?> findByUserName(@PathVariable String userName){
        return ResponseEntity.ok(userService.findByUserName(userName));
    }

    @GetMapping("/api/users/address/{address}")
    public ResponseEntity<?> findByAddress(@PathVariable String address){
        return ResponseEntity.ok(userService.findByAddressContaining(address));
    }

    @GetMapping("/api/users/sort/name")
    public ResponseEntity<?> findAllByOrderByFullNameAsc(){
        return ResponseEntity.ok(userService.findAllByOrderByFullNameAsc());
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateForm form, @PathVariable Long id, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.updateUser(form, id));
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteById(id));
    }
}
