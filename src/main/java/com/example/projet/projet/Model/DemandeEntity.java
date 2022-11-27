package com.example.projet.projet.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "user_id", insertable = false,
// updatable = false)
// @OnDelete(action = OnDeleteAction.CASCADE)
// @Fetch(FetchMode.JOIN)
// private UserEntity user;


@OneToMany(mappedBy = "demande", targetEntity = DemandeServiceEntity.class)
List<DemandeServiceEntity> demandes_services;


// @ManyToMany(fetch = FetchType.LAZY,
// cascade = {
//     CascadeType.PERSIST,
//     CascadeType.MERGE
// })
// @JoinTable(name = "demande_services",
//   joinColumns = { @JoinColumn(name = "demande_id") },
//   inverseJoinColumns = { @JoinColumn(name = "tech_id")})
// private List<TechnicienEntity> techniciens ;





}
