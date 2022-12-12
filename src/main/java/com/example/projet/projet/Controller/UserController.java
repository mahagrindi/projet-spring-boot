package com.example.projet.projet.Controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projet.projet.Model.CategorieEntity;
import com.example.projet.projet.Model.RoleEntity;
import com.example.projet.projet.Model.TechnicienEntity;
import com.example.projet.projet.Model.UserEntity;
import com.example.projet.projet.Service.CategorieService;
import com.example.projet.projet.Service.UserService;
import com.example.projet.projet.Service.technicienService;

@Controller
public class UserController {

    private UserService userService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private technicienService servicetech;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/singup")
    public String singup(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        CategorieEntity categorie = new CategorieEntity();
        model.addAttribute("categorie", categorie);
        model.addAttribute("allusers", userService.selectAll());
        model.addAttribute("allcategorie", categorieService.findAll());

        return "singup";
    }

    @PostMapping("/singup")
    public String saveUser(@ModelAttribute("user") UserEntity user,
            @ModelAttribute("categorie") CategorieEntity categorie, HttpServletRequest request) {
        user.setId(0);
        System.out.println("post \n" + user);
        System.out.println("post achraf test  \n" + user.getRole());
        System.out.println("categorie est " + categorie.getId());
        if (user.getRole().getId() == 3) {
            userService.addUser(user);
            // UserEntity userentity = userService.findByName(user.getName());
            TechnicienEntity technicienEntity = new TechnicienEntity();
            technicienEntity.setCategorie(categorie);
            technicienEntity.getUserEntity().setId(user.getId());
            technicienEntity.setNote(0);
            System.out.println(technicienEntity);
            servicetech.save(technicienEntity);
            request.getSession().setAttribute("technicien", technicienEntity);
            request.getSession().setAttribute("client", userentity);


        } else {
            System.out.println("hello user !");
            userService.addUser(user);
            UserEntity userentity = userService.findByName(user.getName());
            request.getSession().setAttribute("client", userentity);
        }
        return "redirect:/services/all";

    }
    // @RequestMapping(path = "/users/add", method = RequestMethod.POST)
    // @ResponseBody

    // public UserEntity saveUser(@RequestBody UserEntity user) {
    // System.out.println("hello");
    // System.out.println(user);
    // return userService.addUser(user, user.getRole().getId());
    // }
    // @GetMapping("/singup")
    // public String singup(Model model) {
    // UserEntity user = new UserEntity();
    // model.addAttribute("client", user);
    // return "signup";
    // }

    // @GetMapping("/singup")
    // public String singup() {
    // return "singup";
    // }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String getUserById(@PathVariable("id") int userId) {
        return userService.getUserById(userId).toString();
    }

    @RequestMapping(path = "/users/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteService(@PathVariable("id") int userId) {
        return "deleted";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e) {
        return "Error in search :" + e.getMessage();
    }

    @GetMapping("/users/allRole")
    @ResponseBody
    public List<RoleEntity> getAllRole() {
        return userService.getAllRole();
    }

    @GetMapping("/users/allTechnicien")
    @ResponseBody
    public List<TechnicienEntity> getAllTechnicien() {
        return (List<TechnicienEntity>) servicetech.findAll();
    }

}
