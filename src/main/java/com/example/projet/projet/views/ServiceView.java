package com.example.projet.projet.views;

import com.example.projet.projet.Controller.AllArgsConstructor;
import com.example.projet.projet.Model.ServiceEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class ServiceView {

private int idService;
private String Nom;
private double Prix;
private String Description;
private String Image;

private int id_categorie;



public ServiceView(int idService, String nom, double prix, String description, String image, int id_categorie) {
     this.idService = idService;
     Nom = nom;
     Prix = prix;
     Description = description;
     Image = image;
     this.id_categorie = id_categorie;
}



public ServiceEntity buildEntity(){
     return ServiceEntity.builder().id(this.idService).Nom(this.Nom).Prix(this.Prix).Description(this.Description).Image(this.Image).build();
}

}
