package com.javainuse.springbootsecurity.dao.Impl;

import com.javainuse.springbootsecurity.dao.IReclamation;
import com.javainuse.springbootsecurity.dao.enitity.Reclamation;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.dao.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReclamationDaoImpl implements IReclamation {
@Autowired
    ReclamationRepository reclamationRepository;
    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public boolean updateReclamation(Reclamation reclamationser) {
        if (reclamationRepository.save(reclamationser) !=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteReclamation(Long id) {
        if (reclamationRepository.existsById(id)){
            reclamationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Reclamation> findById(Long id) {
        return reclamationRepository.findById(id);
    }

    @Override
    public List<Reclamation>findbyUser(User user) {
        return reclamationRepository.findByUser(user);
    }
}
