package com.zhazha.zha.model;

public class Customer {
    private String customerNumber;
    private String customerAddress;
    private String zip;
    private String customerName;

    public Customer() {
    }

    public Customer(String customerNumber, String customerAddress, String zip, String customerName) {
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.zip = zip;
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }
}
