package com.example.projet.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Repository.TechnicienRepository;

@Service
public class technicienService {
    @Autowired
    TechnicienRepository technicienRepository;

}
