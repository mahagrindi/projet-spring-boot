package com.example.projet.projet.Model;

import java.time.LocalDate;
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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "Demandes")
public class Demandes {
  
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "Prix_Total", nullable = false)
private Double Prix_Total;

@Column(name = "Description", length = 250, nullable = false)
private String Description;

@Column(name = "Date", nullable = false)
private LocalDate  Date;

@Column(name = "Heure", nullable = false)
private String  Heure;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", insertable = false,
updatable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@Fetch(FetchMode.JOIN)
private Users user;


@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
})
@JoinTable(name = "demande_services",
  joinColumns = { @JoinColumn(name = "demande_id") },
  inverseJoinColumns = { @JoinColumn(name = "service_id") })
private Set<Services> services ;


public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Double getPrix_Total() {
    return Prix_Total;
}

public void setPrix_Total(Double prix_Total) {
    Prix_Total = prix_Total;
}

public String getDescription() {
    return Description;
}

public void setDescription(String description) {
    Description = description;
}

public LocalDate getDate() {
    return Date;
}

public void setDate(LocalDate date) {
    Date = date;
}

public String getHeure() {
    return Heure;
}

public void setHeure(String heure) {
    Heure = heure;
}



@Override
public String toString() {
    return "Demandes [id=" + id + ", Prix_Total=" + Prix_Total + ", Description=" + Description + ", Date=" + Date
            + ", Heure=" + Heure + ", user=" + user + "]";
}

}
