package com.example.projet.projet.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Model.TechnicienEntity;
import com.example.projet.projet.Repository.TechnicienRepository;

@Service
public class technicienService {
    @Autowired
    TechnicienRepository technicienRepository;

    public void delete(TechnicienEntity entity) {
        technicienRepository.delete(entity);
    }

    public void deleteAll() {
        technicienRepository.deleteAll();
    }

    public Iterable<TechnicienEntity> findAll() {
        return technicienRepository.findAll();
    }

    public Optional<TechnicienEntity> findById(int id) {
        return technicienRepository.findById(id);
    }

    public TechnicienEntity save(TechnicienEntity entity) {
        return technicienRepository.save(entity);
    }

}
