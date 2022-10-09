package com.learn.spring.two.learningapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.two.learningapi.pojo.Contact;
import com.learn.spring.two.learningapi.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;

    @Override
    public Contact getContactById(int index) {
        return this.contactRepo.getContactById(index);
    }

    @Override
    public void addContact(Contact contact) {
        this.contactRepo.addContact(contact);
    }

    @Override
    public void updateContact(int index, Contact contact){
        this.contactRepo.updateContact(index, contact);
    }

    @Override
    public List<Contact> getListContacts() {
        return this.contactRepo.getListContacts();
    }
    
}
