package edu.neu.csye7374;

import java.util.List;

public interface LegacyTradable {
	
	List<Double> buyersQuotes();
	int performance();
	String getName();
	void setName(String name);
	double getPrice();
	void setPrice(double price);
	String getDescription();
	void setDescription(String description);
	double getAsk();
	void setAsk(double ask);
	List<Double> getBids();
	double getBidTotal();
	void setBidTotal(double bidTotal);
	int getBidCounter();
	void setBidCounter(int bidCounter);
	int getMeteric();
	void setMeteric(int mteric);


}
