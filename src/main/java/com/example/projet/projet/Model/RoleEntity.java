package com.example.projet.projet.Model;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


@Column(name = "Libelle", length = 250, nullable = false, unique = true)
private String Libelle;

@OneToMany(mappedBy = "role", targetEntity = UserEntity.class)
List<UserEntity> users;



  

}
