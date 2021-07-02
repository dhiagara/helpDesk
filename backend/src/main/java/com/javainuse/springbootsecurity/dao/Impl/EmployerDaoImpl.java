package com.javainuse.springbootsecurity.dao.Impl;

import com.javainuse.springbootsecurity.dao.IEmployerDao;
import com.javainuse.springbootsecurity.dao.enitity.Employer;
import com.javainuse.springbootsecurity.dao.repository.EmployerRepository;
import com.javainuse.springbootsecurity.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployerDaoImpl implements IEmployerDao {
    @Autowired
    private EmployerRepository employerRepository;
    @Override
    public List<Employer> getAllEmployer() {
        return employerRepository.findAll();
    }

    @Override
    public Employer addUser(Employer user) {
        return employerRepository.save(user);
    }

    @Override
    public boolean updateEmployer(Employer user) {
        if (employerRepository.save(user) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteEmployer(Long id) {
        if (employerRepository.existsById(id)){
            employerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Employer> findById(Long id) {
        return employerRepository.findById(id);
    }

    @Override
    public Page<Employer> getAllEmployer(Pageable pageable) {
        return null;
    }

    @Override
    public Employer findByEmail(String email) {
        return null;
    }
}
