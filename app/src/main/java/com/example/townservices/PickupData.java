package com.example.townservices;

public class PickupData {

    int pickupimg,pickupaddressimg;
    String pickupname;
    String pickupphoneNumber;

    public PickupData() {
    }

    public PickupData(int pickupimg, int pickupaddressimg, String pickupname, String pickupphoneNumber) {
        this.pickupimg = pickupimg;
        this.pickupaddressimg = pickupaddressimg;
        this.pickupname = pickupname;
        this.pickupphoneNumber = pickupphoneNumber;
    }

    public int getPickupimg() {
        return pickupimg;
    }

    public void setPickupimg(int pickupimg) {
        this.pickupimg = pickupimg;
    }

    public int getPickupaddressimg() {
        return pickupaddressimg;
    }

    public void setPickupaddressimg(int pickupaddressimg) {
        this.pickupaddressimg = pickupaddressimg;
    }

    public String getPickupname() {
        return pickupname;
    }

    public void setPickupname(String pickupname) {
        this.pickupname = pickupname;
    }

    public String getPickupphoneNumber() {
        return pickupphoneNumber;
    }

    public void setPickupphoneNumber(String pickupphoneNumber) {
        this.pickupphoneNumber = pickupphoneNumber;
    }
}
