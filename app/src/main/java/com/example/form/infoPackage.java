package com.example.form;

import java.io.Serializable;

public class infoPackage implements Serializable {

    private String regnr;
    private String orgnr;
    private String companyName;
    private String adress;
    private String postnr;
    private String ort;
    private String email;
    private String telefon;


    public infoPackage(String regnr, String orgnr, String companyName, String adress, String postnr, String ort, String email, String telefon) {
        this.regnr = regnr;
        this.orgnr = orgnr;
        this.companyName = companyName;
        this.adress = adress;
        this.postnr = postnr;
        this.ort = ort;
        this.email = email;
        this.telefon = telefon;
    }

    public String getRegnr() {
        return regnr;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdress() {
        return adress;
    }

    public String getPostnr() {
        return postnr;
    }

    public String getOrt() {
        return ort;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return "infoPackage{" +
                "regnr='" + regnr + '\'' +
                ", companyName='" + companyName + '\'' +
                ", adress='" + adress + '\'' +
                ", postnr='" + postnr + '\'' +
                ", ort='" + ort + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
