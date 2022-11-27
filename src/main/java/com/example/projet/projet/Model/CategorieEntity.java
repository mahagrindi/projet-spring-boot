package com.example.projet.projet.Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
@Table (name = "Categories")
public class CategorieEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String Libelle;


// @OneToMany(targetEntity = UserEntity.class, mappedBy = "id",
// orphanRemoval = false, fetch = FetchType.LAZY)
// private Set<ServiceEntity> service;



@OneToMany(mappedBy = "categorie",targetEntity = ServiceEntity.class)
 List<ServiceEntity> services;

 @OneToMany(mappedBy = "categorie",targetEntity = TechnicienEntity.class)
 List<TechnicienEntity> techniciens;

 


// @OneToMany(targetEntity = TechnicienEntity.class, mappedBy = "id",
// orphanRemoval = false, fetch = FetchType.LAZY)
// private Set<TechnicienEntity> technicien;






}
