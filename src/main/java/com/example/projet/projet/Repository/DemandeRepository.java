package com.example.projet.projet.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.projet.projet.Model.Demandes;

public interface DemandeRepository extends CrudRepository<Demandes,Long> {
    
}
