package edu.neu.csye7374;

public class BearSingleton implements MarketStrategy{

    private static MarketStrategy instance = null;   //Implementing Lazy singleton method

    private BearSingleton() {
        super();
    }

    public static MarketStrategy getInstance() {
        if(instance==null)
        {
            synchronized(BearSingleton.class) {
                if(instance==null) {
                    instance = new BearSingleton();
                }
            }
        }
        return instance;
    }


    @Override
    public int getPerformanceMetric() {
        return -10;
    }
}
