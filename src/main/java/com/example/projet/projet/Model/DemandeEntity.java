package com.example.projet.projet.Model;

import java.sql.Time;
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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Demandes")
public class DemandeEntity {
  
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "prix_total", nullable = false)
private Double prix_total;

@Column(name = "description", length = 250, nullable = false)
private String description;


@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name = "date", nullable = false)
private String  date;

@Column(name = "heure", nullable = false)
private String  heure;


@Column(name = "quantite", columnDefinition = "integer default 1", nullable = false)
private int  qte;


@ManyToOne
private UserEntity user;

@ManyToOne
private ServiceEntity service;


// @OneToMany(mappedBy = "demande", targetEntity = DemandeServiceEntity.class)
// List<DemandeServiceEntity> demandes_services;







}
