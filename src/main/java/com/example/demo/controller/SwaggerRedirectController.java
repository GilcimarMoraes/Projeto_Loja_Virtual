package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerRedirectController  {

    @GetMapping( "/home")
    public String redirectToSwagger() {
        return "redirect:loja_virtual/swagger-ui.html";
    }

    @GetMapping( "/app" )
    public String redirectToApp() {
        return "redirect:loja_virtual/index.html";
    }
}
