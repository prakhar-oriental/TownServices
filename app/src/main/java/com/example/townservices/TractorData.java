package com.example.townservices;

public class TractorData {
    int tractorimg,tractoraddressimg;
    String tractorname;
    String tractorphoneNumber;

    public TractorData() {
    }

    public TractorData(int tractorimg, int tractoraddressimg, String tractorname, String tractorphoneNumber) {
        this.tractorimg = tractorimg;
        this.tractoraddressimg = tractoraddressimg;
        this.tractorname = tractorname;
        this.tractorphoneNumber = tractorphoneNumber;
    }

    public int getTractorimg() {
        return tractorimg;
    }

    public void setTractorimg(int tractorimg) {
        this.tractorimg = tractorimg;
    }

    public int getTractoraddressimg() {
        return tractoraddressimg;
    }

    public void setTractoraddressimg(int tractoraddressimg) {
        this.tractoraddressimg = tractoraddressimg;
    }

    public String getTractorname() {
        return tractorname;
    }

    public void setTractorname(String tractorname) {
        this.tractorname = tractorname;
    }

    public String getTractorphoneNumber() {
        return tractorphoneNumber;
    }

    public void setTractorphoneNumber(String tractorphoneNumber) {
        this.tractorphoneNumber = tractorphoneNumber;
    }
}
