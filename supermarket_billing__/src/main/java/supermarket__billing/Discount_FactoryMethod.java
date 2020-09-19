package supermarket__billing;

import supermarket__billing.model.BOGO_Discount;
import supermarket__billing.model.Discount;
import supermarket__billing.model.Percentage_Discount;

public class Discount_FactoryMethod {
	
	private int buyUnits;
	private int getUnits;
	private double percentage_off;
	
	public int getBuyUnits() {
		return buyUnits;
	}
	public void setBuyUnits(int buyUnits) {
		this.buyUnits = buyUnits;
	}
	public int getGetUnits() {
		return getUnits;
	}
	public void setGetUnits(int getUnits) {
		this.getUnits = getUnits;
	}
	public double getPercentage_off() {
		return percentage_off;
	}
	public void setPercentage_off(double percentage_off) {
		this.percentage_off = percentage_off;
	}
	
	
	public Discount getDiscount(String DiscountType){	
	      if(DiscountType.equalsIgnoreCase("BOGO")){
	    	  return new BOGO_Discount(buyUnits, getUnits);
	      	         
	      } else if(DiscountType.equalsIgnoreCase("percentage_off")){
	    	  return new Percentage_Discount(percentage_off);
	      }
	      return null;
	   }

}
