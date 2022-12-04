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

    public UserEntity addUser(UserEntity user, int rolId) {
        System.out.println("hello in user service \n " + rolId);
        // RoleEntity role = roleRepository.findById(rolId).get();
        // System.out.println("role \n " + role);
        RoleEntity role = new RoleEntity();
        role.setId(rolId);
        role.setLibelle("user");
        user.setRole(role);

        System.out.println("user service \n " + user);
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

}
