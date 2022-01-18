package com.example.karimafullrest.model;

public class Data {
    private Coefficients coefficients;
    private MakeCoefficients makeCoefficients;
    private AvgPurchasePrice avgPurchasePrice;

    public Data(Coefficients coefficients, MakeCoefficients makeCoefficients, AvgPurchasePrice avgPurchasePrice) {
        this.coefficients = coefficients;
        this.makeCoefficients = makeCoefficients;
        this.avgPurchasePrice = avgPurchasePrice;
    }

    public Data() {
    }

    public Coefficients getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Coefficients coefficients) {
        this.coefficients = coefficients;
    }

    public MakeCoefficients getMakeCoefficients() {
        return makeCoefficients;
    }

    public void setMakeCoefficients(MakeCoefficients makeCoefficients) {
        this.makeCoefficients = makeCoefficients;
    }

    public AvgPurchasePrice getAvgPurchasePrice() {
        return avgPurchasePrice;
    }

    public void setAvgPurchasePrice(AvgPurchasePrice avgPurchasePrice) {
        this.avgPurchasePrice = avgPurchasePrice;
    }
}
