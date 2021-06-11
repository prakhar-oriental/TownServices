package com.example.townservices;

public class AutoData {

   int autoimg,addressimg;
   String name;
   String phoneNumber;

    public AutoData() {
    }

    public AutoData(int autoimg, int addressimg, String name, String phoneNumber) {
        this.autoimg = autoimg;
        this.addressimg = addressimg;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getAutoimg() {
        return autoimg;
    }

    public void setAutoimg(int autoimg) {
        this.autoimg = autoimg;
    }

    public int getAddressimg() {
        return addressimg;
    }

    public void setAddressimg(int addressimg) {
        this.addressimg = addressimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
