package com.learn.spring.two.learningapi.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learn.spring.two.learningapi.pojo.Contact;

@Repository
public class ContactRepo {
    
    private List<Contact> contactList = new ArrayList<>();

    public Contact getContactById(int index) {
        return this.contactList.get(index);
    }

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }

    public void updateContact(int index, Contact contact){
        this.contactList.set(index, contact);
    }

    public List<Contact> getListContacts() {
        return this.contactList;
    }

    public void deleteContact(int index) {
        this.contactList.remove(index);
    }
}
