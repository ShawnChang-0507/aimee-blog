package com.fullexception.entity;

public class Address {
    private Integer addressId;

    private Integer parentAddressId;

    private String address;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getParentAddressId() {
        return parentAddressId;
    }

    public void setParentAddressId(Integer parentAddressId) {
        this.parentAddressId = parentAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}