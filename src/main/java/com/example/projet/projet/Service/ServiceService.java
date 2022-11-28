package com.example.projet.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Model.CategorieEntity;
import com.example.projet.projet.Model.ServiceEntity;
import com.example.projet.projet.Repository.CategorieRepository;
import com.example.projet.projet.Repository.ServiceRepository;

@Service
public class ServiceService {
    
    private ServiceRepository serviceRepository;
    @Autowired
    private CategorieRepository catRepo;

@Autowired
public ServiceService(ServiceRepository serviceRepository){
    this.serviceRepository =serviceRepository;
}



public List<ServiceEntity> selectAll(){
    return  (List<ServiceEntity>) serviceRepository.findAll();
}

public ServiceEntity addService(ServiceEntity service, int CatID){
    System.out.println("\n catservice"+catRepo.findById(CatID).get());
    CategorieEntity categorie = catRepo.findById(CatID).get();
    System.out.println("categorie"+categorie);
    service.setCategorie(categorie);
    return serviceRepository.save(service);
 }

 public ServiceEntity getServiceById(int id){
    return serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client ID not found"));
}

public String deleteService(int id) {
    serviceRepository.deleteById(id);
    return "deleted";
}

}
