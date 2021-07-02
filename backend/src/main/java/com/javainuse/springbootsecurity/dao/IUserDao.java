package com.javainuse.springbootsecurity.dao;

import com.javainuse.springbootsecurity.dao.enitity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IUserDao {
    List<User> getAllUsers();
    User addUser (User user);
    boolean updateUser (User user);
    boolean deleteUser (Long id);
    Optional<User> findById(Long id);

    Page<User> getAllUsers(Pageable pageable);
    User  findByEmail(String email);

}
