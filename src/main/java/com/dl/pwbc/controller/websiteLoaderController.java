package com.dl.pwbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class websiteLoaderController {
    @GetMapping("/webLoader")
    public String webLoader(){
        return "website loader success";
    }
}
