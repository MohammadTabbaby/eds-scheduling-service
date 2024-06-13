package com.example.schedulingService.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class Service1Controller {

  @GetMapping(name = "/test",value = "/test")
  public String sayHello() {

    return "Hello From Scheduling-service";
  }


}
