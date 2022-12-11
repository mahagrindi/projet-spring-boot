package com.example.projet.projet.Controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.projet.projet.Model.ServiceEntity;
import com.example.projet.projet.Service.CategorieService;
import com.example.projet.projet.Service.ServiceService;
import com.example.projet.projet.configs.FileUploadUtil;
import com.example.projet.projet.views.ServiceView;

import org.springframework.util.StringUtils;


@Controller
public class ServiceController {

    private ServiceService serviceService;
    private CategorieService categorieService;
    
    //pour l injection
    @Autowired
    public ServiceController(ServiceService serviceService,CategorieService categorieService){
        this.serviceService = serviceService;
        this.categorieService =categorieService;
    }


 @GetMapping("/services/all")
public String viewHomePage(Model model) {
model.addAttribute("allServices", serviceService.selectAll());
return "display-services";
}

 @GetMapping("/services/{id}")
    public String viewDetailsService(@PathVariable("id") int serviceId,Model model) {
        model.addAttribute("detailService", serviceService.getServiceById(serviceId));
        return "details-service";
    }
 
    
    @GetMapping("/add")
    public String saveService(Model model){
        model.addAttribute("service",new ServiceView());
        model.addAttribute("categories", categorieService.findAll());
        return "add-service";
    }


    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String saveService(@ModelAttribute("service") @Valid ServiceView service ,BindingResult result,@RequestParam("image") MultipartFile multipartFile) throws IOException{
    
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        service.setImage(fileName);
        serviceService.addService(service.buildEntity(), service.getId_categorie());
        String uploadDir = "service-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); 
        return "redirect:/services/all";

    }


    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
    model.addAttribute("service", serviceService.getServiceById(id).toView());
    model.addAttribute("categories", categorieService.findAll());
    return "add-service";
    }


    @RequestMapping(path = "/services/delete/{id}")
    public String deleteService(Model model,@PathVariable("id") int serviceId){
    serviceService.deleteService(serviceId);
    return "redirect:/services/all";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e){
        return e.getMessage();
    }


   
   
}
