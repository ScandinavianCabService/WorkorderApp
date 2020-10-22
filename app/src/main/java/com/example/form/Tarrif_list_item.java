package com.example.form;

public class Tarrif_list_item implements Comparable<Tarrif_list_item> {

    double grundpris;
    double krkm;
    double krtim;
    int avg;

    public Tarrif_list_item(double grundpris, double krkm, double krtim, int avg){
        this.grundpris = grundpris;
        this.krkm = krkm;
        this.krtim = krtim;
        this.avg = avg;
    }

    public double getGrundpris() {
        return grundpris;
    }

    public double getKrkm() {
        return krkm;
    }

    public double getKrtim() {
        return krtim;
    }

    public int getAvg() {
        return avg;
    }

    @Override
    public int compareTo(Tarrif_list_item o) {
        if(this.avg < o.avg) {

            return -1;
        }
        if(this.avg == o.avg) {

            return 0;
        }
        return 1;
    }
}
