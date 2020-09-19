package supermarket__billing.model;

public class BOGO_Discount implements Discount {
	
	private int buyUnits;
	private int freeUnits;

	

	public int getBuyUnits() {
		return buyUnits;
	}

	public void setBuyUnits(int buyUnits) {
		this.buyUnits = buyUnits;
	}

	public BOGO_Discount(int buyUnits, int freeUnits) {
		super();
		this.buyUnits=buyUnits;
		this.freeUnits=freeUnits;
	}

	public double getDiscountAmount(double price) {
		return freeUnits*price;
	}
	
	@Override
	public int getMinPurchaseQty() {

		return buyUnits + freeUnits;
	}

}
