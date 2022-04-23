package com.javainuse.springbootsecurity.services;

import com.javainuse.springbootsecurity.dao.enitity.Reclamation;
import com.javainuse.springbootsecurity.dao.enitity.User;

import java.util.List;
import java.util.Optional;

public interface IReclamationService {
    List<Reclamation> getAllReclamation();
    Reclamation addReclamation (Reclamation reclamation);
    boolean updateReclamation (Reclamation reclamationser);
    boolean deleteReclamation (Long id);
    Optional<Reclamation> findById(Long id);
   // List<Reclamation> findbyUser (User user);
    User accrptationReclamation(User user );
}
