package com.learn.spring.two.learningapi.pojo;

import java.util.UUID;

public class Contact {
    private String name;
    private String phoneNumber;
    private String id = UUID.randomUUID().toString();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", id='" + this.getId() + "'" +
            "}";
    }

}
