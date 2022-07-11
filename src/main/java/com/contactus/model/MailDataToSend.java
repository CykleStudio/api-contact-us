package com.contactus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;


public class MailDataToSend {
    private String productName;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private String address;
    private ArrayList<String> productType;
    private ArrayList<String> serviceType;
    private String description;

    @JsonIgnore
    private String template;

    public MailDataToSend(String productName, String firstName, String lastName,
                          String phoneNo, String email, String address,
                          ArrayList<String> productType,
                          ArrayList<String> serviceType, String description) {
        this.productName = productName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.productType = productType;
        this.serviceType = serviceType;
        this.description = description;
    }

    public MailDataToSend() {
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getProductType() {
        return productType;
    }

    public void setProductType(ArrayList<String> productType) {
        this.productType = productType;
    }

    public ArrayList<String> getServiceType() {
        return serviceType;
    }

    public void setServiceType(ArrayList<String> serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
