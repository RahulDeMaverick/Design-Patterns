package edu.neu.csye7374;

public class GoFSingletonStock2Factory extends AbstractStockAPIFactory{

        private static GoFSingletonStock2Factory instance = new GoFSingletonStock2Factory(); // Eager

        private GoFSingletonStock2Factory () {}

        @Override
        public StockAPI getObject() {

            return new Stock2();
        }

        public static GoFSingletonStock2Factory getInstance() {
            return instance;
        }

}