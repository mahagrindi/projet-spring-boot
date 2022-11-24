package com.example.projet.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projet.projet.Model.Services;
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
    public List<Services> getServices(){
        return serviceService.selectAll();
    }

    // similaire a GETMAPPING
    @RequestMapping(path = "/services/add",method = RequestMethod.POST)
    @ResponseBody
    public Services saveService(@RequestBody Services service){
        return serviceService.addService(service);
    }

    @GetMapping("/services/{id}")
    @ResponseBody
    public Services getServiceById(@PathVariable("id") Long serviceId){
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
