package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class StockAPI implements Tradable{

    private String ID;
    private double price;
    private String description;
    private double bid;
    private String tradeType;

    private int meteric;
    private MarketStrategy strategy;


    public int getMeteric() {
        return meteric;
    }

    public void setMeteric(int meteric) {
        this.meteric = meteric;
    }




    public MarketStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MarketStrategy strategy) {
        this.strategy = strategy;
    }

    private List<Double> previousPrices = new ArrayList<>();


    public String getTradeType() {
        return tradeType;
    }
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
        this.previousPrices.add(price);
    }

    public List<Double> getPreviousPrices() {
        return previousPrices;
    }

    public void setPreviousPrices(List<Double> previousPrices) {
        this.previousPrices = previousPrices;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public abstract int getMetric();

    public double getBid() {
        return bid;
    }

    @Override
    public String toString()
    {
        return "StockID: "+this.ID+ ", price: "+this.price + ", Metric: "+this.getMetric()+ ", description: "+this.description + ", previous prices: "+this.previousPrices;
    }

    @Override
    public void setBid(double bid) {
        this.bid = bid;
    }

}
