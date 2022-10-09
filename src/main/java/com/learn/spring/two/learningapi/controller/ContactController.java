package com.learn.spring.two.learningapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.spring.two.learningapi.service.ContactServiceImpl;


@Controller
public class ContactController {
    
    @Autowired
    ContactServiceImpl constactService;
    
}
