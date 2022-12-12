package com.example.projet.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projet.projet.Model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("Select e from UserEntity e where e.Name = ?1")
    // @Query(value = "Select * from Users e where e.name = %?1%", nativeQuery =
    // true)
    public UserEntity findByName(String name);

    @Query("Select e from UserEntity e where e.Email = ?1")
    // @Query(value = "Select * from Users e where e.name = %?1%", nativeQuery =
    // true)
    public UserEntity findByEmail(String email);

}
