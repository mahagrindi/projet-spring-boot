package com.example.projet.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Model.ServiceEntity;
import com.example.projet.projet.Repository.ServiceRepository;

@Service
public class ServiceService {

private ServiceRepository serviceRepository;


@Autowired
public ServiceService(ServiceRepository serviceRepository){
    this.serviceRepository =serviceRepository;
}



public List<ServiceEntity> selectAll(){
    return  (List<ServiceEntity>) serviceRepository.findAll();
}

public ServiceEntity addService(ServiceEntity service){
    return serviceRepository.save(service);
 }

 public ServiceEntity getServiceById(Long id){
    return serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client ID not found"));
}

public String deleteService(Long id) {
    serviceRepository.deleteById(id);
    return "deleted";
}

}
