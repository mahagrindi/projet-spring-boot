package com.example.projet.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Model.Services;
import com.example.projet.projet.Repository.ServiceRepository;

@Service
public class ServiceService {

private ServiceRepository serviceRepository;


@Autowired
public ServiceService(ServiceRepository serviceRepository){
    this.serviceRepository =serviceRepository;
}



public List<Services> selectAll(){
    return  (List<Services>) serviceRepository.findAll();
}

public Services addService(Services service){
    return serviceRepository.save(service);
 }


}
