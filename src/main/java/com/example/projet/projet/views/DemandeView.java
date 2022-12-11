package com.example.projet.projet.views;



import java.time.LocalDate;

import com.example.projet.projet.Model.DemandeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
public class DemandeView {
    
    public int idDemande;
    private Double prix_total;
    private String description;
    private String date;
    private String heure;
    private int qte;
    private int id_service;

    


    public DemandeView(int idDemande, Double prix_total, String description, String date, String heure, int qte,
            int id_service) {
        this.idDemande = idDemande;
        this.prix_total = prix_total;
        this.description = description;
        this.date = date;
        this.heure = heure;
        this.qte = qte;
        this.id_service = id_service;
    }


    public DemandeEntity buildEntity(){
        return DemandeEntity.builder().id(this.idDemande).description(this.description).prix_total(this.prix_total).date(this.date).heure(this.heure).qte(this.qte).build();
    }

    



}
