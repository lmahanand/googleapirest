package io.gopulu.retailmanager.domain;

/**
 * Created by lingrajmahanand on 4/16/17.
 */
public class Address {
    private String number;
    private String postCode;

    public Address(String number, String postCode) {
        this.number = number;
        this.postCode = postCode;
    }

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
