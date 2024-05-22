package com.vccorp.hethongthongtin.repository;

import com.vccorp.hethongthongtin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFullNameContaining(String fullName);
    List<User> findByUserName(String userName);
    List<User> findByAddressContaining(String address);
    List<User> findAllByOrderByFullNameAsc();

    boolean existsByUserName(String userName);
}
