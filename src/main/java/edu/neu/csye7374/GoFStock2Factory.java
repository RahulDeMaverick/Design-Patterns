package edu.neu.csye7374;

public class GoFStock2Factory extends AbstractStockAPIFactory {

    public StockAPI getObject() {

        return new Stock2();
    }
}