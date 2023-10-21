package com.example.storemanagement.repository.dto;

public class StaffFilter {
    private String idNumber;

    public StaffFilter() {

    }

    public StaffFilter(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
