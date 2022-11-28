package com.example.projet.projet.Model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "Demandes")
public class DemandeEntity {
  
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "Prix_Total", nullable = false)
private Double Prix_Total;

@Column(name = "Description", length = 250, nullable = false)
private String Description;

@Column(name = "Date", nullable = false)
private LocalDate  Date;

@Column(name = "Heure", nullable = false)
private String  Heure;

@ManyToOne
private UserEntity user;


@OneToMany(mappedBy = "demande", targetEntity = DemandeServiceEntity.class)
List<DemandeServiceEntity> demandes_services;







}
