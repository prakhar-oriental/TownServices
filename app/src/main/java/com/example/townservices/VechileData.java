package com.example.townservices;

public class VechileData {

    int vechileimg,vechileaddressimg;
    String vechilename;
    String vechilephoneNumber;

    public VechileData() {
    }

    public VechileData(int vechileimg, int vechileaddressimg, String vechilename, String vechilephoneNumber) {
        this.vechileimg = vechileimg;
        this.vechileaddressimg = vechileaddressimg;
        this.vechilename = vechilename;
        this.vechilephoneNumber = vechilephoneNumber;
    }

    public int getVechileimg() {
        return vechileimg;
    }

    public void setVechileimg(int vechileimg) {
        this.vechileimg = vechileimg;
    }

    public int getVechileaddressimg() {
        return vechileaddressimg;
    }

    public void setVechileaddressimg(int vechileaddressimg) {
        this.vechileaddressimg = vechileaddressimg;
    }

    public String getVechilename() {
        return vechilename;
    }

    public void setVechilename(String vechilename) {
        this.vechilename = vechilename;
    }

    public String getVechilephoneNumber() {
        return vechilephoneNumber;
    }

    public void setVechilephoneNumber(String vechilephoneNumber) {
        this.vechilephoneNumber = vechilephoneNumber;
    }
}
