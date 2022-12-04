package com.example.projet.projet.views;

import com.example.projet.projet.Model.ServiceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceView {

private String Nom;
private double Prix;
private String Description;
private String Image;

private int id_categorie;


public ServiceEntity buildEntity(){
     return ServiceEntity.builder().Nom(this.Nom).Prix(this.Prix).Description(this.Description).Image(this.Image).build();
}

}
