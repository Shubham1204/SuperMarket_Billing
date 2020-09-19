package supermarket__billing.model;

public class CartItem extends Item {
	
	private int quantity;
	private double actual_Item_Price;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getActual_Item_Price() {
		return actual_Item_Price;
	}

	public void setActual_Item_Price(double actual_Item_Price) {
		this.actual_Item_Price = actual_Item_Price;
	}

	
	public CartItem(int quantity, Item item) {	
		super(item.getName(), item.getUnitPrice(), item.getUnit(), item.getDiscountType(), item.getDiscount(), item.getSubcategoryname(), item.getCategoryname());
		this.quantity = quantity;
		this.actual_Item_Price =getUnitPrice()*quantity;
	}

	

	@Override
	public String toString() {
		return "CartItem [qty=" + quantity + ", amount=" + actual_Item_Price + "]";
	}

}
