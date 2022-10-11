package com.learn.spring.two.learningapi.service;

import java.util.List;

import com.learn.spring.two.learningapi.pojo.Contact;

public interface ContactService {

    public Contact getContactById(int index);

    public void addContact(Contact contact);

    public int updateContact(String id, Contact contact);

    public List<Contact> getListContacts();

    public Contact getContactByIdObj(String id);

    public int findIndex(String id);

    public int deleteContact(String id);
}
