package com.javainuse.springbootsecurity.dao.repository;

import com.javainuse.springbootsecurity.dao.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailId(String email);
}
