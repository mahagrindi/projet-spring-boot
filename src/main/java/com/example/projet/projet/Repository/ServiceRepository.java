package com.example.projet.projet.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.projet.Model.ServiceEntity;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity,Long> {
  
    
}
