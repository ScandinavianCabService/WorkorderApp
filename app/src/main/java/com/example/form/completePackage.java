package com.example.form;

import java.util.ArrayList;

public class completePackage {

    private String task;
    private String taxameter;
    private ArrayList<Integer> tarrifs;
    private String regnr;
    private String orgnr;
    private String companyName;
    private String adress;
    private String postnr;
    private String ort;
    private String email;
    private String telefon;

    public completePackage(infoPackage bio, String task, String taxameter, ArrayList<Integer> tarrifs) {

        this.regnr = bio.getRegnr();
        this.orgnr = bio.getOrgnr();
        this.companyName = bio.getCompanyName();
        this.adress = bio.getAdress();
        this.postnr = bio.getPostnr();
        this.ort = bio.getOrt();
        this.email = bio.getEmail();
        this.telefon = bio.getTelefon();
        this.task = task;
        this.taxameter = taxameter;
        this.tarrifs = tarrifs;

    }

    public String getTask() {
        return task;
    }

    public String getTaxameter() {
        return taxameter;
    }

    public ArrayList<Integer> getTarrifs() {
        return tarrifs;
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
        return  task + ':' +
                taxameter + ':' +
                tarrifs + ":" +
                regnr + ':' +
                orgnr + ':' +
                companyName + ':' +
                adress + ':' +
                postnr + ':' +
                ort + ':' +
                email + ':' +
                telefon;
    }
}
