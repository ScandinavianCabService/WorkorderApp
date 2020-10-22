package com.example.form;

public class Tarrif {

    private int basePrice;
    private int basePriceDesi = 0;
    private int km;
    private int kmDesi = 0;
    private int tim;
    private int timDesi = 0;

    private int averagePrice;
    private int getAveragePriceDesi = 0;

    public Tarrif(String basePrice, String km, String tim, String averagePrice) {

        if (basePrice.contains(",")) {

            this.basePrice = Integer.parseInt(basePrice.split(".")[0]);
            this.basePriceDesi = Integer.parseInt(basePrice.split(".")[1]);

        } else {

            this.basePrice = Integer.parseInt(basePrice);

        }

        if (km.contains(",")) {

            this.km = Integer.parseInt(km.split(".")[0]);
            this.kmDesi = Integer.parseInt(km.split(".")[1]);

        } else {

            this.km = Integer.parseInt(km);

        }

        if (tim.contains(",")) {

            this.tim = Integer.parseInt(tim.split(".")[0]);
            this.timDesi = Integer.parseInt(tim.split(".")[1]);

        } else {

            this.tim = Integer.parseInt(tim);

        }

        if(averagePrice.contains(",")) {

            if (tim.contains(",")) {

                this.averagePrice = Integer.parseInt(averagePrice.split(".")[0]);
                this.getAveragePriceDesi = Integer.parseInt(averagePrice.split(".")[1]);

            } else {

                this.averagePrice = Integer.parseInt(averagePrice);

            }

        }


    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getBasePriceDesi() {
        return basePriceDesi;
    }

    public int getKm() {
        return km;
    }

    public int getKmDesi() {
        return kmDesi;
    }

    public int getTim() {
        return tim;
    }

    public int getTimDesi() {
        return timDesi;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public int getGetAveragePriceDesi() {
        return getAveragePriceDesi;
    }
}
