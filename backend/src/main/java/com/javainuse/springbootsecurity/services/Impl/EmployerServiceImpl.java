package com.javainuse.springbootsecurity.services.Impl;

import com.javainuse.springbootsecurity.dao.IEmployerDao;
import com.javainuse.springbootsecurity.dao.enitity.Employer;
import com.javainuse.springbootsecurity.services.IEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements IEmployerService {
    @Autowired
    IEmployerDao iEmployerDao;
    @Override
    public List<Employer> getAllEmployer() {
        return iEmployerDao.getAllEmployer();
    }

    @Override
    public Employer addUser(Employer user) {
        return iEmployerDao.addUser(user);
    }

    @Override
    public boolean updateEmployer(Employer user) {
        return iEmployerDao.updateEmployer(user);
    }

    @Override
    public boolean deleteEmployer(Long id) {
        return iEmployerDao.deleteEmployer(id);
    }

    @Override
    public Optional<Employer> findById(Long id) {
        return iEmployerDao.findById(id);
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
