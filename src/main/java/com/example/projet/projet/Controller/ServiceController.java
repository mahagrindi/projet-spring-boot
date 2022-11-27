package com.example.projet.projet.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projet.projet.Model.ServiceEntity;
import com.example.projet.projet.Service.ServiceService;


@Controller
public class ServiceController {

    private ServiceService serviceService;
    
    //pour l injection
    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    @RequestMapping(path = "/services/all",method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceEntity> getServices(){
        return serviceService.selectAll();
    } 


//     @GetMapping("/services/all")
// public String viewHomePage(Model model) {
// model.addAttribute("allServices", serviceService.selectAll());
// return "display-services";
// }

    // similaire a POSTMAPPING
    @RequestMapping(path = "/services/add",method = RequestMethod.POST)
    @ResponseBody
    public String saveService(Model model){
        model.addAttribute("newService",new ServiceEntity());
        return "add-service";
    }

    // public Services saveService(@RequestBody Services service){
    //     return serviceService.addService(service);
    // }

    @GetMapping("/services/{id}")
    @ResponseBody
    public ServiceEntity getServiceById(@PathVariable("id") Long serviceId){
       return serviceService.getServiceById(serviceId);
    }


    @RequestMapping(path = "/services/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteService(@PathVariable("id") Long serviceId){
    return "deleted";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e){
        return "Error in search :"+e.getMessage();
    }


   
   
}
