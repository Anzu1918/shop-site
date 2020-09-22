package com.co.chubb.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
    @GetMapping("/item")
    public String list(){
        return "item";
    }

}