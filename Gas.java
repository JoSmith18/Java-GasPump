package com.company;

public class Gas {
    public String type;
    public double amount;
    public double gallons;

    Gas(String type, double amount, double gallons){
        this.type = type;
        this.amount = amount;
        this.gallons = gallons;
    }



public double getRegCost(double gallons){
        return Math.round(gallons * 2.19 * 100.0) / 100.0;
}

public double getRegGallons(double amount){
        return Math.round(amount / 2.19 * 100.0) /100.0;
}

public double getMidCost(double gallons){
        return Math.round(gallons * 2.32 * 100.0) / 100.0;
}

public double getMidGallons(double amount){
        return Math.round(amount / 2.32 * 100.0) /100.0;
}

public double getPremCost(double gallons){
        return Math.round(gallons * 2.49 * 100.0) /100.0 ;
}

public double getPremGallons(double amount){
        return Math.round(amount / 2.49 * 100.0) / 100.0;
}


}

