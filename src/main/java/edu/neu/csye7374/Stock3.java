package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Stock3 implements LegacyTradable{

	private String name;
	private double price;
	private String description;
	private double ask;
	private List<Double> bids=null;
	private double bidTotal;
	private int bidCounter;
	private int metric;
	
	
	
	public Stock3(String name, double price, String description, double ask) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.ask = ask;
		this.bidCounter = 0;
		this.metric=1;
	}

	@Override
	public List<Double> buyersQuotes() {
		
		if(this.bids==null) {
			
			List<Double> bids = new ArrayList<>();
			
			for(int i=1; i<6; i++) {
				double n = 90+Math.random()*10;
				bids.add(n);
				System.out.println("Bid amount added to Amazon stock: "+n);
				this.bidTotal+=n;
			}
			this.bidCounter = 6;
			this.bids = bids;
		}
		
		return this.bids;
	}

	@Override
	public int performance() {
		return 1;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public double getAsk() {
		return ask;
	}

	@Override
	public void setAsk(double ask) {
		this.ask = ask;
	}

	@Override
	public List<Double> getBids() {
		return bids;
	}

	
	public void setBids(List<Double> bids) {
		this.bids = bids;
	}

	@Override
	public double getBidTotal() {
		return bidTotal;
	}

	@Override
	public void setBidTotal(double bidTotal) {
		this.bidTotal = bidTotal;
	}

	@Override
	public int getBidCounter() {
		return bidCounter;
	}

	@Override
	public void setBidCounter(int bidCounter) {
		this.bidCounter = bidCounter;
	}

	@Override
	public int getMeteric() {
		return metric;
	}

	@Override
	public void setMeteric(int metric) {
		this.metric = metric;
	}

}
