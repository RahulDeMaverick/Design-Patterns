package edu.neu.csye7374;

public class GoFStock1Factory extends AbstractStockAPIFactory{

        public StockAPI getObject() {

            return new Stock1();
        }
}
