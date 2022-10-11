package com.learn.spring.two.learningapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.two.learningapi.handler.RequestException;
import com.learn.spring.two.learningapi.pojo.Contact;
import com.learn.spring.two.learningapi.pojo.Response;
import com.learn.spring.two.learningapi.service.ContactServiceImpl;

@RestController
public class ContactController {
    
    @Autowired
    ContactServiceImpl contactService;

    @GetMapping("/contact/{id}")
    public ResponseEntity<Response<Contact>> getData(@PathVariable String id) {
        Contact foundContact = this.contactService.getContactByIdObj(id);
        System.out.println(foundContact);
        if(foundContact == null) throw new RequestException("id: "+ id + " not found");
        return new ResponseEntity<>(Response.sendResponse(foundContact), HttpStatus.OK);
    }

    @GetMapping("/contact/all")
    public ResponseEntity<Response<List<Contact>>> getAll() {
        List<Contact> contacts = this.contactService.getListContacts();
        if(contacts.size() == 0) throw new RequestException("Contacs not found");
        return new ResponseEntity<>(Response.sendResponse(contacts), HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<Response<Contact>> createContact(@RequestBody Contact contact) {
        this.contactService.addContact(contact);
        return new ResponseEntity<Response<Contact>>(Response.sendResponse(contact), HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Response<Contact>> updateContact(@RequestBody Contact contact, @PathVariable String id) {
        int sucessUpdatingOrNot = this.contactService.updateContact(id, contact);
        if(sucessUpdatingOrNot == 1) return new ResponseEntity<>(Response.sendResponse(contact),HttpStatus.OK);
        else throw new RequestException("id: " + id + " not found");
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<Response> deleteContact(@PathVariable String id) {
        int num = this.contactService.deleteContact(id);
        if(num == 0) throw new RequestException("id: " + id + " not found");
        else return new ResponseEntity<>(Response.sendResponse(null), HttpStatus.OK);
    }
}
