package com.cdqf.domain;

public class Cardid {
    private String cid;
    private String cpassword;
    private double deposit;

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Cardid() {
    }

    public Cardid(String cid, String cpassword,double deposit) {
        this.cid = cid;
        this.cpassword = cpassword;
        this.deposit = deposit;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    @Override
    public String toString() {
        return "Cardid{" +
                "cid='" + cid + '\'' +
                ", cpassword='" + cpassword + '\'' +
                ", deposit='" + deposit + '\''+
                '}';
    }
}
