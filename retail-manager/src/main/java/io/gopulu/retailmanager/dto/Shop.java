package io.gopulu.retailmanager.dto;

import java.io.Serializable;

/**
 * Created by lingrajmahanand on 4/16/17.
 */
public class Shop implements Serializable {
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNumber(){
        return this.address.getNumber();
    }

    public String getPostCode(){
        return this.getAddress().getPostCode();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address {
    private String number;
    private String postCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
