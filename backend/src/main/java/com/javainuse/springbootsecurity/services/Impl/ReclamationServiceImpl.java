package com.javainuse.springbootsecurity.services.Impl;

import com.javainuse.springbootsecurity.dao.IReclamation;
import com.javainuse.springbootsecurity.dao.enitity.Reclamation;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.services.IReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements IReclamationService {
    @Autowired
    IReclamation iReclamation;
    @Override
    public List<Reclamation> getAllReclamation() {
        return iReclamation.getAllReclamation();
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return iReclamation.addReclamation(reclamation);
    }

    @Override
    public boolean updateReclamation(Reclamation reclamationser) {
        return iReclamation.updateReclamation(reclamationser);
    }

    @Override
    public boolean deleteReclamation(Long id) {
        return iReclamation.deleteReclamation(id);
    }

    @Override
    public Optional<Reclamation> findById(Long id) {
        return iReclamation.findById(id);
    }

    @Override
    public List <Reclamation> findbyUser(User user) {
        return iReclamation.findbyUser(user);
    }
}
