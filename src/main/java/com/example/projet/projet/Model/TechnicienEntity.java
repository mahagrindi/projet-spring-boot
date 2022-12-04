package com.example.projet.projet.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "Techniciens")
public class TechnicienEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 250, nullable = false)
    private String Nom;
    @Column(name = "Prenom", length = 250, nullable = false)
    private String Prenom;
    @Column(name = "Note", columnDefinition = "Decimal(10,2) default '0'")
    private double Note;
    @Column(name = "Phone", length = 8, nullable = false, unique = true)
    private Long Phone;
    @Column(name = "Email", length = 250, nullable = false, unique = true)
    @Pattern(regexp = "^[/w/d]+@[/w/d]+/.[/w/d]+$", message = "Email not valid")
    private String Email;
    @Column(name = "Adresse", length = 250, nullable = false)
    private String Adresse;

    // @ManyToMany(fetch = FetchType.LAZY,
    // cascade = {
    // CascadeType.PERSIST,
    // CascadeType.MERGE
    // },
    // mappedBy = "Techniciens")

    @ManyToOne
    private CategorieEntity categorie;

    @OneToMany(mappedBy = "technicien", targetEntity = DemandeServiceEntity.class)
    List<DemandeServiceEntity> demandes_services;

}
