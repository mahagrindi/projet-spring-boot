package com.example.projet.projet.Model;


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
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


@Column(name = "Libelle", length = 250, nullable = false)
private String Libelle;

@OneToMany(targetEntity = Users.class, mappedBy = "id",
orphanRemoval = false, fetch = FetchType.LAZY)
private Set<Users> user;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getLibelle() {
    return Libelle;
}

public void setLibelle(String libelle) {
    Libelle = libelle;
}

public Set<Users> getUser() {
    return user;
}

public void setUser(Set<Users> user) {
    this.user = user;
}

@Override
public String toString() {
    return "Roles [id=" + id + ", Libelle=" + Libelle + ", user=" + user + "]";
}

  

}
