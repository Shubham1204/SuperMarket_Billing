package supermarket__billing.model;

public class Percentage_Discount implements Discount {
	private double percent_discount;

	public double getPercent_discount() {
		return percent_discount;
	}

	public void setPercent_discount(double percent_discount) {
		this.percent_discount = percent_discount;
	}
	
	public double getDiscountAmount(double price) {
		
		return (percent_discount*price)/100;
	}
	
	
	public Percentage_Discount(double percent) {
		super();
		this.percent_discount = percent;
	}
	
	@Override
	public int getMinPurchaseQty() {

		return 0;
	}

	@Override
	public int getBuyUnits() {
		return 0;
	}

}
