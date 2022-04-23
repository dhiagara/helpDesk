package com.javainuse.springbootsecurity.dao;

import com.javainuse.springbootsecurity.dao.enitity.Reclamation;
import com.javainuse.springbootsecurity.dao.enitity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IReclamation {
    List<Reclamation> getAllReclamation();
    Reclamation addReclamation (Reclamation reclamation);
    boolean updateReclamation (Reclamation reclamationser);
    boolean deleteReclamation (Long id);
    Optional<Reclamation> findById(Long id);
   // List<Reclamation> findbyUser (User user);

}
