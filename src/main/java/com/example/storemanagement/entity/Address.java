package com.example.storemanagement.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @NonNull
    private String addressLine1;
    private String addressLine2;
    @NonNull
    private String suburb;
    @NonNull
    private String city;
    private String state;
    @NonNull
    private Country country;
    private Byte zipCode;

    public Address() {

    }

    public Address(@NonNull String addressLine1, String addressLine2, @NonNull String suburb, @NonNull String city,
                   String state, @NonNull Country country, Byte zipCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    @NonNull
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(@NonNull String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @NonNull
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(@NonNull String suburb) {
        this.suburb = suburb;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @NonNull
    public Country getCountry() {
        return country;
    }

    public void setCountry(@NonNull Country country) {
        this.country = country;
    }

    public Byte getZipCode() {
        return zipCode;
    }

    public void setZipCode(Byte zipCode) {
        this.zipCode = zipCode;
    }
}
