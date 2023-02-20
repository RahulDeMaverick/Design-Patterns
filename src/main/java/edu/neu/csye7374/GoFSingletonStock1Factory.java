package edu.neu.csye7374;

public class GoFSingletonStock1Factory extends AbstractStockAPIFactory{

    private static GoFSingletonStock1Factory instance = null; // Lazy

    private GoFSingletonStock1Factory () {}

    @Override
    public StockAPI getObject() {
        return new Stock1();
    }

    public static GoFSingletonStock1Factory getInstance() {
        if (instance == null) {
            instance = new GoFSingletonStock1Factory();
        }
        return instance;
    }
}
