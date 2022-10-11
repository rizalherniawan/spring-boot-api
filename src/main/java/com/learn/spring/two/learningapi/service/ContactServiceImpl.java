package com.learn.spring.two.learningapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.two.learningapi.handler.RequestException;
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
    public int updateContact(String id, Contact contact){
        int index = this.findIndex(id);
        System.out.println(index);
        if(index == -1) {
            return 0;
        } else {
            this.contactRepo.updateContact(index, contact);
            return 1;
        }
    }

    @Override
    public int findIndex(String id) {
        List<Contact> contacts = this.getListContacts();
        return contacts.indexOf(contacts.stream().filter(x -> id.equals(x.getId())).findFirst().orElseThrow(() -> new RequestException("id of " + id + " not found"))); 
    }

    @Override
    public List<Contact> getListContacts() {
        return this.contactRepo.getListContacts();
    }

    @Override
    public Contact getContactByIdObj(String id) {
        List<Contact> contacs = this.getListContacts();
        if(contacs.size() == 0) return null;
        Contact foundContact = contacs.stream().filter(x -> id.equals(x.getId())).findFirst().orElseThrow(() -> new RequestException("id of " + id + " not found"));
        return foundContact; 
    }

    @Override
    public int deleteContact(String id) {
        int index = this.findIndex(id);
        if(index == -1) {
            return 0;
        } else {
            this.contactRepo.deleteContact(index);
            return 1;
        }
    }
}
