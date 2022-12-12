package com.example.projet.projet.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projet.projet.Model.DemandeEntity;
import com.example.projet.projet.Model.UserEntity;
import com.example.projet.projet.Service.DemandeService;
import com.example.projet.projet.Service.ServiceService;
import com.example.projet.projet.Service.UserService;
import com.example.projet.projet.views.DemandeView;

@Controller
public class DemandeController {
    


private DemandeService demandeService;
private UserService userService;
private ServiceService serviceService;




@Autowired
public DemandeController(DemandeService demandeService, ServiceService serviceService,UserService userService){
    this.demandeService = demandeService;
    this.userService = userService;
    this.serviceService = serviceService;
}


@GetMapping("/demandes/all")
public String displayDemande(Model model,HttpServletRequest request){
    UserEntity user = (UserEntity) request.getSession().getAttribute("client");
    model.addAttribute("user", user);
    model.addAttribute("allDemandes", demandeService.selectAll());
    // model.addAttribute("service", demandeService.getService(null));
    return "display-demande";
}


@GetMapping("/demande/add/{id}")
public String saveDemande(Model model, @PathVariable("id") int serviceId){
    model.addAttribute("demande", new DemandeView());
    model.addAttribute("service", serviceService.getServiceById(serviceId));
    return "add-demande";
}


@PostMapping("/demande/add")
public String saveService(@ModelAttribute("demande") @Valid DemandeView demande,HttpServletRequest request
){
    UserEntity user = (UserEntity) request.getSession().getAttribute("client");
    System.out.println("affichage session"+user);
    System.out.println("user id " + user.getId());
    demandeService.addDemande(demande.buildEntity(), user.getId(), demande.getId_service());
    return "redirect:/demandes/all";
}

@RequestMapping("/demande/update/{id}")
public String updateDemande(@PathVariable("id") int id,Model model){
   demandeService.updateDemande(demandeService.getDemandeById(id));
    return "redirect:/demandes/all";
}

}
