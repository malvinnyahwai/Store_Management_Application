package com.example.storemanagement.entity;

import javax.persistence.Embeddable;

@Embeddable
public class ContactInformation {
    private String phoneNumber;
    private String email;

    public ContactInformation() {

    }

    public ContactInformation(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
