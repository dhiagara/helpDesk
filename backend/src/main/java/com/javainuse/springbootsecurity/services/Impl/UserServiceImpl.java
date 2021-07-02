package com.javainuse.springbootsecurity.services.Impl;

import com.javainuse.springbootsecurity.dao.IUserDao;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService{
    @Autowired
    ServletContext context;
    @Autowired
    IUserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Override
    public User addUser(User user ) {
        User newUser = new User();
        user.setRole("ROLE_USER");
        if(user.getEmailId().equals("admin")){
            user.setRole("ROLE_ADMIN");
        }

        newUser.setEmailId(user.getEmailId());
        newUser.setTel(user.getTel());
        newUser.setNom(user.getNom());
        newUser.setPrenom(user.getPrenom());
        newUser.setNumSerie(user.getNumSerie());

        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userDao.addUser(newUser);

    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User findById(Long id) {

        Optional<User> clintOptional= userDao.findById(id);
        return  clintOptional.orElseThrow(()-> new EntityNotFoundException("User Not found with id "+ id));

    }


    @Override
    public UserDetails findByEmail(String email) throws UsernameNotFoundException  {
        List<SimpleGrantedAuthority> roles = null;


        User user = userDao.findByEmail(email);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name " +email);
    }

    @Override
    public User findByEmaill(String email) {
        return  userDao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;


        User user = userDao.findByEmail(email);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name " +email);
    }




}
