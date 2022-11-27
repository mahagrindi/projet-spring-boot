package com.example.projet.projet.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.projet.projet.Model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    
}
