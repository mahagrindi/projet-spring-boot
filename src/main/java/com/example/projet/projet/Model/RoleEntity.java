package com.example.projet.projet.Model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
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

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getLibelle() {
    return Libelle;
}

public void setLibelle(String libelle) {
    Libelle = libelle;
}

public List<UserEntity> getUsers() {
    return users;
}

public void setUsers(List<UserEntity> users) {
    this.users = users;
}



  

}
