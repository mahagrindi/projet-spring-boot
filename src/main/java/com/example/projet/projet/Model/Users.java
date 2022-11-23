package com.example.projet.projet.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
public class Users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


@Column(name = "Nom", length = 250, nullable = false)
private String Nom;
@Column(name = "Prenom", length = 250, nullable = false)
private String Prenom;
@Column(name = "Email", length = 250, nullable = false)
private String Email;
@Column(name = "Phone", length = 8, nullable = false)
private Long Phone;
@Column(name = "Adresse", length = 250, nullable = false)
private String Adresse;

// @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
// cascade = CascadeType.ALL)
// private Set<Users> user;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "role_id", insertable = false,
updatable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@Fetch(FetchMode.JOIN)
private Roles role;

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

public String getEmail() {
    return Email;
}

public void setEmail(String email) {
    Email = email;
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

public Roles getRole() {
    return role;
}

public void setRoles(Roles role) {
    this.role = role;
}

@Override
public String toString() {
    return "Users [id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Email=" + Email + ", Phone=" + Phone
            + ", Adresse=" + Adresse + ", roles=" + role + "]";
}



}
