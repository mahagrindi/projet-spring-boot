package com.example.projet.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projet.projet.Model.Services;
import com.example.projet.projet.Service.ServiceService;


@Controller
public class ServiceController {

    private ServiceService serviceService;
    

    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    @RequestMapping(path = "/services/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Services> getServices(){
        return serviceService.selectAll();
    }

    @RequestMapping(path = "/services/add",method = RequestMethod.POST)
    @ResponseBody
    public Services saveClient(@RequestBody Services service){
        return serviceService.addService(service);
    }




    // @GetMapping("/services")
    // public String getServices(Model model){
    //     model.addAttribute("allServices", serviceService.selectAll());
    //     return "index";
    // }
    
   
}
