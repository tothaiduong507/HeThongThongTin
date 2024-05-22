package com.vccorp.hethongthongtin.service;

import com.vccorp.hethongthongtin.dto.UserDto;
import com.vccorp.hethongthongtin.entity.User;
import com.vccorp.hethongthongtin.exception.ConflictExcpetion;
import com.vccorp.hethongthongtin.exception.NotFoundException;
import com.vccorp.hethongthongtin.exception.Response;
import com.vccorp.hethongthongtin.form.UserCreateForm;
import com.vccorp.hethongthongtin.form.UserUpdateForm;
import com.vccorp.hethongthongtin.mapper.UserMapper;
import com.vccorp.hethongthongtin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Override
    public Response create(UserCreateForm form) {
        var user = UserMapper.mapToUser(form);
        if(!userRepository.existsByUserName(user.getUserName())){
            var savedUser = userRepository.save(user);
            List<User> users = new ArrayList<>();
            users.add(savedUser);
            return new Response(HttpStatus.OK, "Added user successfully", 200, UserMapper.mapToUserDtoList(users));

        }
        throw new ConflictExcpetion("Username already exists");
    }


//    @Override
//    public UserDto create(UserCreateForm form) {
//        var user = UserMapper.mapToUser(form);
//        var savedUser = userRepository.save(user);
//        return UserMapper.mapToUserDto(savedUser);
//    }

    @Override
    public Response findById(Long id) {
        var result = userRepository.findById(id);
        if(result.isPresent()){
            List<User> users = new ArrayList<>();
            users.add(result.get());
            return new Response(HttpStatus.FOUND,"User information", 200,UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("User does not exist in the system");
    }

    @Override
    public Response findByUserName(String userName) {
        var users = userRepository.findByUserName(userName);
        if(!users.isEmpty()){
            return new Response(HttpStatus.FOUND, "User information", 200, UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("Username cannot be found.");
    }

    @Override
    public Response findByFullName(String fullName) {
        var users = userRepository.findByFullNameContaining(fullName);
        if(!users.isEmpty()){
            return new Response(HttpStatus.FOUND, "User information", 200, UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("Name cannot be found.");
    }

    @Override
    public Response findByAddressContaining(String address) {
        var users = userRepository.findByAddressContaining(address);
        if(!users.isEmpty()){
            return new Response(HttpStatus.FOUND, "User information", 200, UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("Address cannot be found.");
    }

    @Override
    public Response findAllByOrderByFullNameAsc() {
        var users = userRepository.findAllByOrderByFullNameAsc();
        if(!users.isEmpty()){
            return new Response(HttpStatus.FOUND, "Users information order by fullname: ", 200, UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("There is no user.");
    }

    @Override
    public Response updateUser(UserUpdateForm form, Long id) {
        if(userRepository.existsById(id)){
            if(userRepository.existsByUserName(form.getUserName())){
                throw new ConflictExcpetion("Username already exists");
            }
            var user = userRepository.findById(id).get();
            UserMapper.updateUser(form, user);
            var savedUser = userRepository.save(user);
            List<User> users = new ArrayList<>();
            users.add(savedUser);
            return new Response(HttpStatus.OK, "Updated user successfully", 200, UserMapper.mapToUserDtoList(users));
        }
        throw new NotFoundException("ID not found");
    }

    @Override
    public Response deleteById(Long id) {
        if(!userRepository.existsById(id)){
            return new Response(HttpStatus.OK, "There is no user with the provided id", 200);
        }
        userRepository.deleteById(id);
        return new Response(HttpStatus.OK, "User deleted successfully", 200);
    }
}
