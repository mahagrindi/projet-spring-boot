package com.example.projet.projet.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.projet.Model.RoleEntity;
import com.example.projet.projet.Model.UserEntity;
import com.example.projet.projet.Repository.RoleRepository;
import com.example.projet.projet.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> selectAll() {
        return userRepository.findAll();
    }

    public UserEntity addUser(UserEntity user) {
        // RoleEntity re = new RoleEntity();
        // // RoleEntity role = (RoleEntity)roleRepository.findById(rolId).get();
        // List<RoleEntity> roles = (List<RoleEntity>) roleRepository.findAll();
        // System.out.println("role \n " + roles);
        // for (RoleEntity roleEntity : roles) {
        // if (roleEntity.getId() == rolId) {
        // re = roleEntity;
        // }
        // }
        // // RoleEntity role = new RoleEntity();
        // // (user.getRole()).setId(rolId);
        // // // role.setId(rolId);
        // // (user.getRole()).setLibelle("user");
        // user.setRole(re);
        return userRepository.save(user);
    }

    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client ID not found"));
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    public UserEntity findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<RoleEntity> getAllRole() {
        return (List<RoleEntity>) roleRepository.findAll();
    }

}
