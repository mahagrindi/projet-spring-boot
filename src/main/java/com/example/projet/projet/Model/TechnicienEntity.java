package com.example.projet.projet.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Techniciens")
public class TechnicienEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Note", columnDefinition = "Decimal(10,2) default '0'")
    private double Note;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

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
