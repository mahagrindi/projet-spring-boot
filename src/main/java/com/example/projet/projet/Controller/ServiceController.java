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

    // @RequestMapping(path = "/services/all",method = RequestMethod.GET)
    // @ResponseBody
    // public List<ServiceEntity> getServices(){
    //     return serviceService.selectAll();
    // } 

    @GetMapping(value = "/services")
    public List<ServiceEntity> getServ(){
        return serviceService.selectAll();
    }

    // @PostMapping("/save")
    // public ResponseEntity<ServiceEntity> saveServ(@RequestBody ServiceEntity servObj){
    //     serviceService.addService(servObj);
    //     return new ResponseEntity<>(HttpStatus.CREATED);
    // }

    @GetMapping("/services/all")
public String viewHomePage(Model model) {
model.addAttribute("allServices", serviceService.selectAll());
return "display-services";
}

    // similaire a POSTMAPPING
    
    @GetMapping("/add")
    public String saveService(Model model){
        model.addAttribute("newService",new ServiceView());
        model.addAttribute("categories", categorieService.findAll());
        return "add-service";
    }


    @RequestMapping(path = "/services/add",method = RequestMethod.POST)
    public String saveService(@ModelAttribute("newService") @Valid ServiceView service ,BindingResult result,@RequestParam("image") MultipartFile multipartFile) throws IOException{
        
        // if(result.hasErrors()){
        //     return "add-service";
        // }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        service.setImage(fileName);
        serviceService.addService(service.buildEntity(), service.getId_categorie());
        String uploadDir = "service-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile); 
        // if (!multipartFile.isEmpty()){
        //     String orgFileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //     String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
        //     String fileName = "voiture-"+service.getNom()+ext;
        //     String uploadDir = "services-photos/";
        //     FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        //     service.setImage("/"+uploadDir+fileName);
        //     serviceService.addService(service.buildEntity(), service.getId_categorie());
        // }
        return "redirect:/services/all";
        // return serviceService.addService(service, 1);

    }

    @GetMapping("/services/{id}")
    @ResponseBody
    public String viewDetailsService(@PathVariable("id") int serviceId,Model model) {
        model.addAttribute("detailService", serviceService.getServiceById(serviceId));
        return "details-service";
        }

    // @GetMapping("/services/{id}")
    // @ResponseBody
    // public ServiceEntity viewDetailsService(@PathVariable("id") int serviceId){
    //     // return serviceService.addService(service, service.getCategorie().getId());
    //     return serviceService.getServiceById(serviceId);

    // }
   



    @RequestMapping(path = "/services/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteService(@PathVariable("id") int serviceId){
    return "deleted";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e){
        return e.getMessage();
    }


   
   
}
