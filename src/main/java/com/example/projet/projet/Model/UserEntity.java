package com.example.projet.projet.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 250, nullable = false)
    private String Name;
    @Column(name = "Prenom", length = 250, nullable = false)
    private String Prenom;
    @Column(name = "Email", length = 250, nullable = false, unique = true)
    private String Email;
    @Column(name = "Phone", length = 8, nullable = false, unique = true)
    private Long Phone;
    @Column(name = "Adresse", length = 250, nullable = false)
    private String Adresse;
    @Column(name = "Password", length = 250, nullable = false)
    private String Password;
    @JsonBackReference
    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "user", targetEntity = DemandeEntity.class)
    private List<DemandeEntity> demande;

    @OneToOne(mappedBy = "userEntity")
    private TechnicienEntity technicienEntity;

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", Name=" + Name + ", Prenom=" + Prenom + ", Email=" + Email + ", Phone="
                + Phone + ", Adresse=" + Adresse + ", Password=" + Password + ", role=" + role.getLibelle()
                + ", demande="
                + demande
                + "]";
    }

}
