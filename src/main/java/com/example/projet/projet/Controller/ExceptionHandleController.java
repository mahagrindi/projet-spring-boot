package com.example.projet.projet.Controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandleController {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolation(DataIntegrityViolationException e, Model model){
        model.addAttribute("errorCode","Unique Data Exp");
        model.addAttribute("errorMsg",e.getMessage());
    return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
        model.addAttribute("errorCode","Something Wrong");
        model.addAttribute("errorMsg",e.getMessage());
        return "error";
    }

}
