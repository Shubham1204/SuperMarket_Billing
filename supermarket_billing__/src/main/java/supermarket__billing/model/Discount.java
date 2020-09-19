package supermarket__billing.model;

public interface Discount {
	
	public double getDiscountAmount(double price);
    public int getMinPurchaseQty();
    public int getBuyUnits();

}
