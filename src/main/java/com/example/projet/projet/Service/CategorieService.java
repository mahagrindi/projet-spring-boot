package com.example.projet.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projet.projet.Controller.AllArgsConstructor;
import com.example.projet.projet.Model.CategorieEntity;
import com.example.projet.projet.Repository.CategorieRepository;

@Service
@AllArgsConstructor
public class CategorieService {

    private CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public CategorieEntity getCategorieById(int id) {
        return categorieRepository.findById(id).get();
    }

    public List<CategorieEntity> findAll() {
        return (List<CategorieEntity>) categorieRepository.findAll();
    }

}
