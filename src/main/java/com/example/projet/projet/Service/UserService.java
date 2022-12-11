package com.example.projet.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Controller.AllArgsConstructor;
import com.example.projet.projet.Model.UserEntity;
import com.example.projet.projet.Repository.UserRepository;


@Service
@AllArgsConstructor
public class UserService {
    
private UserRepository userRepository;

@Autowired
public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
}

    public List<UserEntity> findAll(){
        return (List<UserEntity>) userRepository.findAll();    }

}
