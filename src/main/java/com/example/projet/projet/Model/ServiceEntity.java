package com.example.projet.projet.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.projet.projet.Controller.AllArgsConstructor;
import com.example.projet.projet.views.ServiceView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Builder
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
@Table (name = "Services")
public class ServiceEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;


private String Nom;

private double Prix;

private String Description;

private String Image;




@JsonBackReference
@ManyToOne(targetEntity = CategorieEntity.class, fetch = FetchType.LAZY)
private CategorieEntity categorie;

@OneToMany(mappedBy = "service", targetEntity = DemandeServiceEntity.class)
List<DemandeServiceEntity> demandes_services;

public ServiceEntity() {
    this.categorie = new CategorieEntity();
}

public ServiceEntity(int id, String nom, double prix, String description, String image, CategorieEntity categorie,
        List<DemandeServiceEntity> demandes_services) {
    this.id = id;
    Nom = nom;
    Prix = prix;
    Description = description;
    Image = image;
    this.categorie = categorie;
    this.demandes_services = demandes_services;
}

public ServiceView toView(){
    return ServiceView.builder()
    .idService(this.id)
    .Nom(this.Nom)
    .Description(this.Description)
    .Image(this.Image)
    .Prix(this.Prix)
    .id_categorie(this.categorie.getId())
    .build(); 
}















}