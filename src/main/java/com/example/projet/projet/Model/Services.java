package com.example.projet.projet.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "Services")
public class Services {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "Nom", length = 250, nullable = false)
private String Nom;
@Column(name = "Prix", length = 4, nullable = false)
private long Prix;
@Column(name = "Description", length = 250, nullable = false)
private String Description;
@Column(name = "Image", length = 250, nullable = false)
private String Image;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "categorie_id", insertable = false,
updatable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@Fetch(FetchMode.JOIN)
private Categories categorie;


@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
},
mappedBy = "Services")

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNom() {
    return Nom;
}

public void setNom(String nom) {
    Nom = nom;
}

public long getPrix() {
    return Prix;
}

public void setPrix(long prix) {
    Prix = prix;
}

public String getDescription() {
    return Description;
}

public void setDescription(String description) {
    Description = description;
}

public String getImage() {
    return Image;
}

public void setImage(String image) {
    Image = image;
}

public Categories getCategorie() {
    return categorie;
}

public void setCategorie(Categories categorie) {
    this.categorie = categorie;
}

@Override
public String toString() {
    return "Services [id=" + id + ", Nom=" + Nom + ", Prix=" + Prix + ", Description=" + Description + ", Image="
            + Image + ", categorie=" + categorie + "]";
}













}