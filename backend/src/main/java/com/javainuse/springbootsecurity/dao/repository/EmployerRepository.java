package com.javainuse.springbootsecurity.dao.repository;

import com.javainuse.springbootsecurity.dao.enitity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {
    Employer findByEmailId(String email);
}
