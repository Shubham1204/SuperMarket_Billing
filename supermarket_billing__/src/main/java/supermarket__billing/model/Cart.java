package supermarket__billing.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private String customerName;
	protected List<CartItem> cartItems;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}


	public Cart(String customerName) {
		super();
		this.customerName = customerName;
		this.cartItems = new ArrayList<>();
	}



}
