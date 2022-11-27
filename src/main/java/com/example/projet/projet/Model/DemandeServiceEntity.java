package com.example.projet.projet.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
@Table (name = "Demande_service")
public class DemandeServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


@ManyToOne
private ServiceEntity service;

@ManyToOne
private DemandeEntity demande;

@ManyToOne
private TechnicienEntity technicien;
}
