package pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
private Integer bkID;
private String bkCode;
private String bkName;
private String bkAuthor;
private String bkPress;
private Date bkDAtePress;
private String bkISBN;
private String bkCatalog;
private String bkLanguage;
private Integer bkPages;
private BigDecimal bkPrice;
private Date bkDateIn;
private String bkBrief;
private String bkCover;
private String bkStatus;

    public Book() {
    }

    public Book(Integer bkID, String bkCode, String bkName, String bkAuthor, String bkPress, Date bkDAtePress, String bkISBN, String bkCatalog, String bkLanguage, Integer bkPages, BigDecimal bkPrice, Date bkDateIn, String bkBrief, String bkCover, String bkStatus) {
        this.bkID = bkID;
        this.bkCode = bkCode;
        this.bkName = bkName;
        this.bkAuthor = bkAuthor;
        this.bkPress = bkPress;
        this.bkDAtePress = bkDAtePress;
        this.bkISBN = bkISBN;
        this.bkCatalog = bkCatalog;
        this.bkLanguage = bkLanguage;
        this.bkPages = bkPages;
        this.bkPrice = bkPrice;
        this.bkDateIn = bkDateIn;
        this.bkBrief = bkBrief;
        this.bkCover = bkCover;
        this.bkStatus = bkStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkID=" + bkID +
                ", bkCode='" + bkCode + '\'' +
                ", bkName='" + bkName + '\'' +
                ", bkAuthor='" + bkAuthor + '\'' +
                ", bkPress='" + bkPress + '\'' +
                ", bkDAtePress=" + bkDAtePress +
                ", bkISBN='" + bkISBN + '\'' +
                ", bkCatalog='" + bkCatalog + '\'' +
                ", bkLanguage='" + bkLanguage + '\'' +
                ", bkPages=" + bkPages +
                ", bkPrice=" + bkPrice +
                ", bkDateIn=" + bkDateIn +
                ", bkBrief='" + bkBrief + '\'' +
                ", bkCover='" + bkCover + '\'' +
                ", bkStatus='" + bkStatus + '\'' +
                '}';
    }

    public Integer getBkID() {
        return bkID;
    }

    public void setBkID(Integer bkID) {
        this.bkID = bkID;
    }

    public String getBkCode() {
        return bkCode;
    }

    public void setBkCode(String bkCode) {
        this.bkCode = bkCode;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public String getBkPress() {
        return bkPress;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public Date getBkDAtePress() {
        return bkDAtePress;
    }

    public void setBkDAtePress(Date bkDAtePress) {
        this.bkDAtePress = bkDAtePress;
    }

    public String getBkISBN() {
        return bkISBN;
    }

    public void setBkISBN(String bkISBN) {
        this.bkISBN = bkISBN;
    }

    public String getBkCatalog() {
        return bkCatalog;
    }

    public void setBkCatalog(String bkCatalog) {
        this.bkCatalog = bkCatalog;
    }

    public String getBkLanguage() {
        return bkLanguage;
    }

    public void setBkLanguage(String bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public Integer getBkPages() {
        return bkPages;
    }

    public void setBkPages(Integer bkPages) {
        this.bkPages = bkPages;
    }

    public BigDecimal getBkPrice() {
        return bkPrice;
    }

    public void setBkPrice(BigDecimal bkPrice) {
        this.bkPrice = bkPrice;
    }

    public Date getBkDateIn() {
        return bkDateIn;
    }

    public void setBkDateIn(Date bkDateIn) {
        this.bkDateIn = bkDateIn;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public String getBkCover() {
        return bkCover;
    }

    public void setBkCover(String bkCover) {
        this.bkCover = bkCover;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
    }
}
