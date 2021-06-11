package com.example.townservices;

public class Data {
    int image;
    String servicename;

    public Data() {
    }

    public Data(int image, String servicename) {
        this.image = image;
        this.servicename = servicename;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }
}
