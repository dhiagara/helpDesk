package com.javainuse.springbootsecurity.dao.Impl;

import com.javainuse.springbootsecurity.dao.IUserDao;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.dao.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        if (userRepository.save(user) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }



    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findByEmail(String email) {
         return  userRepository.findByEmailId(email);
    }
}
