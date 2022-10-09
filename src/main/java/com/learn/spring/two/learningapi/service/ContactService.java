package com.learn.spring.two.learningapi.service;

import java.util.List;

import com.learn.spring.two.learningapi.pojo.Contact;

public interface ContactService {

    public Contact getContactById(int index);

    public void addContact(Contact contact);

    public void updateContact(int index, Contact contact);

    public List<Contact> getListContacts();
}
