package com.example.projet.projet.Model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
@Table(name = "Users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


@Column(name = "Nom", length = 250, nullable = false)
private String Nom;
@Column(name = "Prenom", length = 250, nullable = false)
private String Prenom;
@Column(name = "Email", length = 250, nullable = false, unique = true)
@Pattern(regexp = "^[/w/d]+@[/w/d]+/.[/w/d]+$", message = "Email not valid")
private String Email;
@Column(name = "Phone", length = 8, nullable = false, unique = true)
private Long Phone;
@Column(name = "Adresse", length = 250, nullable = false)
private String Adresse;

@ManyToOne
private RoleEntity role;


@OneToMany(mappedBy = "user",targetEntity = DemandeEntity.class)
private List<DemandeEntity> demande;

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "role_id", insertable = false,
// updatable = false)
// @OnDelete(action = OnDeleteAction.CASCADE)
// @Fetch(FetchMode.JOIN)
// private RoleEntity role;



}
