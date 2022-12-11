package pojo;

import java.security.PrivateKey;
import java.util.Date;

public class Reader {
    private String rdID;
    private String rdName;
    private String rdSex;
    private Integer rdType=0;
    private String rdDept;
    private String rdPhone;
    private String rdEmail;
    private Date rdDateReg;
    private String rdPhoto="web/static/img/default.jpg";
    private String rdStatus="有效";
    private Integer rdBorrow;
    private String rdPwd;
    private Integer rdAdminRoles=0;

    public Reader(String rdID, String rdPwd) {
        this.rdID = rdID;
        this.rdPwd = rdPwd;
    }

    public Reader() {
    }

    public Reader(String rdID, String rdName, String rdSex, Integer rdType, String rdDept, String rdPhone, String rdEmail, Date rdDateReg, String rdPhoto, String rdStatus, Integer rdBorrow, String rdPwd, Integer rdAdminRoles) {
        this.rdID = rdID;
        this.rdName = rdName;
        this.rdSex = rdSex;
        this.rdType = rdType;
        this.rdDept = rdDept;
        this.rdPhone = rdPhone;
        this.rdEmail = rdEmail;
        this.rdDateReg = rdDateReg;
        this.rdPhoto = rdPhoto;
        this.rdStatus = rdStatus;
        this.rdBorrow = rdBorrow;
        this.rdPwd = rdPwd;
        this.rdAdminRoles = rdAdminRoles;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rdID='" + rdID + '\'' +
                ", rdName='" + rdName + '\'' +
                ", rdSex='" + rdSex + '\'' +
                ", rdType=" + rdType +
                ", rdDept='" + rdDept + '\'' +
                ", rdPhone='" + rdPhone + '\'' +
                ", rdEmail='" + rdEmail + '\'' +
                ", rdDateReg=" + rdDateReg +
                ", rdPhoto='" + rdPhoto + '\'' +
                ", rdStatus='" + rdStatus + '\'' +
                ", rdBorrow=" + rdBorrow +
                ", rdPwd='" + rdPwd + '\'' +
                ", rdAdminRoles=" + rdAdminRoles +
                '}';
    }

    public String getRdID() {
        return rdID;
    }

    public void setRdID(String rdID) {
        this.rdID = rdID;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public String getRdSex() {
        return rdSex;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
    }

    public Integer getRdType() {
        return rdType;
    }

    public void setRdType(Integer rdType) {
        this.rdType = rdType;
    }

    public String getRdDept() {
        return rdDept;
    }

    public void setRdDept(String rdDept) {
        this.rdDept = rdDept;
    }

    public String getRdPhone() {
        return rdPhone;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public Date getRdDateReg() {
        return rdDateReg;
    }

    public void setRdDateReg(Date rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public String getRdPhoto() {
        return rdPhoto;
    }

    public void setRdPhoto(String rdPhoto) {
        this.rdPhoto = rdPhoto;
    }

    public String getRdStatus() {
        return rdStatus;
    }

    public void setRdStatus(String rdStatus) {
        this.rdStatus = rdStatus;
    }

    public Integer getRdBorrow() {
        return rdBorrow;
    }

    public void setRdBorrow(Integer rdBorrow) {
        this.rdBorrow = rdBorrow;
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }

    public Integer getRdAdminRoles() {
        return rdAdminRoles;
    }

    public void setRdAdminRoles(Integer rdAdminRoles) {
        this.rdAdminRoles = rdAdminRoles;
    }
}
