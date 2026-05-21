package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.HelloWorldService;
/* Para testes
*
* curl -X POST http://localhost:8080/hello-world/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Seu Nome", "email": "seu.email@exemplo.com"}'
*
*
*  */gi
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;
    @GetMapping
    public String helloWorld(){
        return helloWorldService.helloWorld("Lucas");
    }
    @PostMapping("/{id}")
    String HelloWorldPost(@PathVariable("id") String id,
                          @RequestParam(value="filter", defaultValue = "nenhum") String filter,
                          @RequestBody User body){
        return "Hello World post " + body.getName() + " " + id + filter;
    }
}
