package com.javainuse.springbootsecurity.dao;

import com.javainuse.springbootsecurity.dao.enitity.Employer;
import com.javainuse.springbootsecurity.dao.enitity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployerDao {
    List<Employer> getAllEmployer();
    Employer addUser (Employer user);
    boolean updateEmployer (Employer user);
    boolean deleteEmployer (Long id);
    Optional<Employer> findById(Long id);

    Page<Employer> getAllEmployer(Pageable pageable);
    Employer  findByEmail(String email);
}
