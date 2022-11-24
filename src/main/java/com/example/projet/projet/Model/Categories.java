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
@Table (name = "Categories")
public class Categories {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "Libelle", length = 250, nullable = false)
private String Libelle;


@OneToMany(targetEntity = Users.class, mappedBy = "id",
orphanRemoval = false, fetch = FetchType.LAZY)
private Set<Services> service;


@OneToMany(targetEntity = Techniciens.class, mappedBy = "id",
orphanRemoval = false, fetch = FetchType.LAZY)
private Set<Techniciens> technicien;


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


public Set<Services> getService() {
    return service;
}


public void setService(Set<Services> service) {
    this.service = service;
}


public Set<Techniciens> getTechnicien() {
    return technicien;
}


public void setTechnicien(Set<Techniciens> technicien) {
    this.technicien = technicien;
}


@Override
public String toString() {
    return "Categories [id=" + id + ", Libelle=" + Libelle + ", service=" + service + ", technicien=" + technicien
            + "]";
}






}
