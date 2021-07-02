package com.javainuse.springbootsecurity.services;


import com.javainuse.springbootsecurity.dao.enitity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IUserService {
    List<User> getAllUsers();
    User addUser (User user );
    boolean updateUser (User user);
    boolean deleteUser (Long id);
    User findById(Long id);

    UserDetails findByEmail(String email);
    User findByEmaill(String email);

}
