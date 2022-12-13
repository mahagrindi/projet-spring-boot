package com.example.projet.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.projet.projet.Model.DemandeEntity;
import com.example.projet.projet.Model.UserEntity;

import io.lettuce.core.dynamic.annotation.Param;

public interface DemandeRepository extends JpaRepository<DemandeEntity,Integer> {
    @Query("Select e from DemandeEntity e where e.etat = 'acceptee'  and e.user= :user")
    // @Query(value = "Select * from Users e where e.name = %?1%", nativeQuery =
    // true)
    public List<DemandeEntity> findByEtat(
        @Param("user") UserEntity user
    );


    @Query("Select e from DemandeEntity e where e.etat = 'en attente' and e.user= :user")
    // @Query(value = "Select * from Users e where e.name = %?1%", nativeQuery =
    // true)
    public List<DemandeEntity> currentDemande(
        @Param("user") UserEntity user
    );

    @Query("Select e from DemandeEntity e where e.etat = :etat ")
    public List<DemandeEntity> demandeToAccept(
        @Param("etat") String etat
    );



}
