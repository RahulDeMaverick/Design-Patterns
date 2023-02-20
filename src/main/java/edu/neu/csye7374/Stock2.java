package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stock2 extends StockAPI {

    List<Double> previousPrices =new ArrayList<>(Arrays.asList(100.0,222.3,333.4,533.5,633.6,700.7));

    @Override
    public int getMetric() {
        int metric = getStrategy().getPerformanceMetric();
        setMeteric(metric);
        return metric;
    }

}

