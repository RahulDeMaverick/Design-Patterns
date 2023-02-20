package edu.neu.csye7374;

public class BullSingleton implements MarketStrategy{

    private static MarketStrategy instance = null;   //Implementing Lazy singleton method

    private BullSingleton() {
        super();
    }

    public static MarketStrategy getInstance() {
        if(instance==null)
        {
            synchronized(BullSingleton.class) {
                if(instance==null) {
                    instance = new BullSingleton();
                }
            }
        }
        return instance;
    }



    @Override
    public int getPerformanceMetric() {
        return 10;
    }

}
