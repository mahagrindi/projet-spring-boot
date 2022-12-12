package com.example.projet.projet.Service;

import java.util.List;

import org.apache.naming.ServiceRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projet.projet.Model.DemandeEntity;
import com.example.projet.projet.Model.ServiceEntity;
import com.example.projet.projet.Model.UserEntity;
import com.example.projet.projet.Repository.DemandeRepository;
import com.example.projet.projet.Repository.ServiceRepository;
import com.example.projet.projet.Repository.UserRepository;

@Service
public class DemandeService {
    

private DemandeRepository demandeRepository;

@Autowired
private UserRepository userRepository;
@Autowired
private ServiceRepository serviceRepository;

@Autowired
private ServiceService serviceService;


@Autowired
public DemandeService(DemandeRepository demandeRepository){
    this.demandeRepository = demandeRepository;
}

public List<DemandeEntity> selectAll(){
    return  (List<DemandeEntity>) demandeRepository.findAll();
}

public List<DemandeEntity> historiqueDemande(UserEntity user){
    return (List<DemandeEntity>) demandeRepository.findByEtat(user);
}


public DemandeEntity addDemande(DemandeEntity demande,int userId,int serviceId){
    UserEntity user = userRepository.findById(userId).get();
    ServiceEntity service = serviceRepository.findById(serviceId).get();
    demande.setUser(user);
    demande.setService(service);
    demande.setPrix_total(service.getPrix()*demande.getQte());
    demande.setEtat("en attente");
    return demandeRepository.save(demande);
 }

 public DemandeEntity getDemandeById(int id){
    return demandeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("demande ID not found"));
}


public String deleteDemande(int id) {
    demandeRepository.deleteById(id);
    return "demande deleted";
}

public DemandeEntity updateDemande(DemandeEntity demande){
    demande.setEtat("acceptee");
    return demandeRepository.save(demande);
}





}
