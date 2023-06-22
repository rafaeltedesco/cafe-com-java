package com.minhaempresa.petshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("public")
public class PublicController {

    @GetMapping
    public Map<String, Object> publicRoute() {
        return new HashMap<>() {
            {
                put("message", "public route");
            }
        };
    }
}
