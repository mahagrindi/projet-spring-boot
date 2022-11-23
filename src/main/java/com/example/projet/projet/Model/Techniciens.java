package com.example.projet.projet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Techniciens")
public class Techniciens {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(name = "Nom", length = 250, nullable = false)
private String Nom;
@Column(name = "Prenom", length = 250, nullable = false)
private String Prenom;
@Column(name = "Note",  columnDefinition="Decimal(10,2) default '0'")
private double Note;
@Column(name = "Phone", length = 8, nullable = false)
private Long Phone;
@Column(name = "Adresse", length = 250, nullable = false)
private String Adresse;


@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
},
mappedBy = "Services")


public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNom() {
    return Nom;
}
public void setNom(String nom) {
    Nom = nom;
}
public String getPrenom() {
    return Prenom;
}
public void setPrenom(String prenom) {
    Prenom = prenom;
}
public double getNote() {
    return Note;
}
public void setNote(double note) {
    Note = note;
}
public Long getPhone() {
    return Phone;
}
public void setPhone(Long phone) {
    Phone = phone;
}
public String getAdresse() {
    return Adresse;
}
public void setAdresse(String adresse) {
    Adresse = adresse;
}
@Override
public String toString() {
    return "Techniciens [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Note=" + Note + ", Phone=" + Phone
            + ", Adresse=" + Adresse + "]";
}


}
