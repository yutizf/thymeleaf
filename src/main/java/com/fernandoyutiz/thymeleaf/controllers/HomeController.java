package com.fernandoyutiz.thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${entorno}")
    String entorno;

    @GetMapping("/hello")
    public String hello(Model model){
        Map<String,String> mapa= new HashMap<>();
        mapa.put("saludo","Buenos dias");
        mapa.put("nombre", "Fernando");
        mapa.put("entorno", entorno);
        model.addAttribute("mapa",mapa);
        return "hello";
    }
}
