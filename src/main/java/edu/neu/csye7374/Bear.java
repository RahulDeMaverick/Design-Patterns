package edu.neu.csye7374;

public class Bear implements MarketStrategy {

    public Bear() {
        super();
    }

    @Override
    public int getPerformanceMetric() {
        return -1;
    }
}
