package com.example.projet.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.projet.Model.ServiceEntity;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
  
    @Query(value = "select * from ServiceEntity s where s.categorie like %:keyword% ", nativeQuery = true)
    List<ServiceEntity> findByKeyword(@Param("keyword") String keyword);
}
