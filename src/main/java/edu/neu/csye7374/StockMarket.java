package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class StockMarket {

    private static StockMarket instance;
    private List<StockAPI> stocks= new ArrayList<>();
    private List<Tradable> stocklist;
    private List<String> tradedstocks=new ArrayList<>();

    private List<Double> previousStocks = new ArrayList<>();

    private StockMarket() {
        super();
        stocklist = new ArrayList<>();
    }
    public List<StockAPI> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockAPI> stocks) {
        this.stocks = stocks;
    }

    public List<String> getTradedstocks() {
        return tradedstocks;
    }

    public void setTradedstocks(List<String> tradedstocks) {
        this.tradedstocks = tradedstocks;
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

//    public void addStock(StockAPI s)
//    {
//        getStocks().add(s);
//    }

    public void addStock(Tradable adapter) {
        this.stocklist.add(adapter);
    }

    public void removeStock(StockAPI s)
    {
        getStocks().remove(s);
    }

    public void addTrade(String s)
    {
        tradedstocks.add(s);
    }

    public void showTrades()
    {
        System.out.println("Traded stocks Now...");
        for (String t : tradedstocks)
        {System.out.println(t);}
    }

    public void showStocks()
    {
        System.out.println("Stock Market Now...");
        for (StockAPI s : getStocks())
        {System.out.println(s.toString());}
    }

    public void trade(StockAPI s)
    {
        System.out.println("get metric>>>>>>>>>>>>>>>"+s.getMetric());

        if (s.getMetric()>0)
        {
            if (s.getBid() >= s.getPrice() )
            {
                String  tradebuystock = s.getID() + " Buying " + s.getPrice();
                addTrade(tradebuystock);
            }
        }
        else
        {
            String  tradesellstock = s.getID() + " Selling " + s.getPrice();
            addTrade(tradesellstock);
        }

        s.setPrice(s.getPrice()+s.getMetric());
    }


    public static void demo() {

        LegacyTradable amazon = new Stock3("Amazon", 100, "Amazon Stocks", 90);
        Tradable adapter = new StockAdapter(amazon);

        //adapter pattern

        //creating market
        StockMarket stockMarket = StockMarket.getInstance();
        System.out.println("Stocks: ");
        stockMarket.showStocks();
        System.out.println("TradedStocks: ");
        stockMarket.showTrades();


        //  GoFFactory Pattern

        AbstractStockAPIFactory factory1 = new GoFStock1Factory();
        AbstractStockAPIFactory factory2 = new GoFStock2Factory();
        StockAPI fctStock1 = factory1.getObject();
        StockAPI fctStock2 = factory2.getObject();
        //StockAPI fctStock3 = factory2.getObject();
        {
            fctStock1.setID("walmart");
            fctStock1.setPrice(290);
            fctStock1.setDescription("WMT");
            fctStock1.setBid(0.0);
            fctStock1.setTradeType("interday");
            fctStock1.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0, 222.3, 333.4, 533.5, 633.6, 700.7)));
            fctStock1.setStrategy(new Bull());
        }
        {
            fctStock2.setID("Amazon");
            fctStock2.setPrice(296.0);
            fctStock2.setDescription("AMZN");
            fctStock2.setBid(0.0);
            fctStock2.setTradeType("intraday");
            fctStock2.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0, 222.3, 333.4, 533.5, 633.6, 700.7)));
            fctStock2.setStrategy(new Bear());

        }
        stockMarket.addStock(adapter);
        System.out.println("Amazon stock added successfully");
        System.out.println("Adapter design pattern");
        System.out.println();
        // fctStock3.setID("Best buy");fctStock3.setPrice(304.40);fctStock3.setDescription("BBY");fctStock3.setBid(0.0);fctStock3.setTradeType(null);fctStock3.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0,222.3,333.4,533.5,633.6,700.7)));fctStock1.setStrategy(new Bull());
        stockMarket.addStock(fctStock1);
        stockMarket.addStock(fctStock2);
        //stockMarket.addStock(fctStock3);

        System.out.println(" view of stock market");
        stockMarket.showStocks();

        System.out.println("--------------------------------------------------------------------");
        // simulation of trading on fctStock1
        for (int i=0; i<3; i++)
        {
            double start = fctStock1.getPrice();
            double end = fctStock1.getPrice()+10;
            double random = new Random(System.currentTimeMillis()+9).nextDouble();
            double bid_now = start + (random * (end - start));
            System.out.println("Bidding on WMT: "+bid_now);
            System.out.println("After bid on WMT of stock market");
            fctStock1.setBid(bid_now);
            stockMarket.showStocks();
            System.out.println("After trade on WMT of stock market");
            stockMarket.trade(fctStock1);
            stockMarket.showTrades();
        }

        System.out.println("--------------------------------------------------------------------");
        // simulation of trading on fctStock2
        for (int i=0; i<3; i++)
        {
            double start = fctStock2.getPrice();
            double end = fctStock2.getPrice()+fctStock2.getMetric();
            double random = new Random(System.currentTimeMillis()+7).nextDouble();
            double bid_now = start + (random * (end - start));
            System.out.println("Bidding on AMZN: "+bid_now);
            System.out.println("After bid on AMZN of stock market");
            fctStock2.setBid(bid_now);
            stockMarket.showStocks();
            System.out.println("After trade on AMZN of stock market");
            stockMarket.trade(fctStock2);
            stockMarket.showTrades();
        }
        System.out.println("--------------------------------------------------------------------");
 


        //viewing stocks
        stockMarket.showStocks();
        System.out.println("Adding another stocks using GoF+Singleton");

        System.out.println("____________________________________________");

        //Factory pattern with singleton

        AbstractStockAPIFactory factory3 = GoFSingletonStock1Factory.getInstance();
        AbstractStockAPIFactory factory4 = GoFSingletonStock2Factory.getInstance();
        StockAPI s5 = factory3.getObject();
        StockAPI s6 = factory4.getObject();
        //StockAPI s7 = f4.getObject();
        {
            s5.setID("Intel");
            s5.setPrice(49.40);
            s5.setDescription("INTC");
            s5.setBid(0.0);
            s5.setTradeType(null);
            s5.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0, 222.3, 333.4, 533.5, 633.6, 700.7)));
            s5.setStrategy(BullSingleton.getInstance()); // bull singleton stratergy
        }
        {
            s6.setID("AMD");
            s6.setPrice(97.90);
            s6.setDescription("AMD");
            s6.setBid(0.0);
            s6.setTradeType(null);
            s6.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0, 222.3, 333.4, 533.5, 633.6, 700.7)));
            s6.setStrategy(BearSingleton.getInstance()); //bear singleton
        }
        //s7.setID("Apple");s7.setPrice(102.80);s7.setDescription("APPL");s7.setBid(0.0);s7.setTradeType(null);s7.setPreviousPrices(new ArrayList<>(Arrays.asList(100.0,222.3,333.4,533.5,633.6,700.7)));
        stockMarket.addStock(s5);
        stockMarket.addStock(s6);
        //stockMarket.addStock(s7);

        //viewing stocks
        stockMarket.showStocks();

        System.out.println("--------------------------------------------------------------------");
        // simulation of trading on s5
        for (int i=0; i<3; i++)
        {
            double start = s5.getPrice();
            double end = s5.getPrice()+s5.getMetric();
            double random = new Random(System.currentTimeMillis()+9).nextDouble();
            double bid_now = start + (random * (end - start));
            System.out.println("Bidding on INTC: "+bid_now);
            System.out.println("After bid on INTC of stock market");
            s5.setBid(bid_now);
            stockMarket.showStocks();
            System.out.println("After trade on INTC of stock market");
            stockMarket.trade(s5);
            stockMarket.showTrades();
        }

        System.out.println("--------------------------------------------------------------------");
        // simulation of trading on s6
        for (int i=0; i<3; i++)
        {
            double start = s6.getPrice();
            double end = s6.getPrice()+s6.getMetric();
            double random = new Random(System.currentTimeMillis()+7).nextDouble();
            double bid_now = start + (random * (end - start));
            System.out.println("Bidding on AMD: "+bid_now);
            System.out.println("After bid on AMD of stock market");
            s6.setBid(bid_now);
            stockMarket.showStocks();
            System.out.println("After trade on AMD of stock market");
            stockMarket.trade(s6);
            stockMarket.trade((StockAPI)adapter);
            stockMarket.showTrades();
        }
        System.out.println("--------------------------------------------------------------------");
        

        System.out.println("--------------------------------------------------------------------");
        System.out.println("End of day Display of stock market");
        stockMarket.showStocks();
        System.out.println("End of day trades executed");
        stockMarket.showTrades();
    }
}
