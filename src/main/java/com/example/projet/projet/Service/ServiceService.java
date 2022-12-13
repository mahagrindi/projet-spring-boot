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

public ServiceEntity addService(ServiceEntity service,int CatID){
    CategorieEntity categorie = catRepo.findById(CatID).get();
    // List<CategorieEntity> categories = (List<CategorieEntity>) catRepo.findAll();

    service.setCategorie(categorie);
    return serviceRepository.save(service);
 }

 public ServiceEntity getServiceById(int id){
    return serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("service ID not found"));
}

public String deleteService(int id) {
    serviceRepository.deleteById(id);
    return "deleted";
}

public List<ServiceEntity> getByKeyword(String keyword){
    return serviceRepository.findByKeyword(keyword);
   }

}
