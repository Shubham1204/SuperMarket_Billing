package supermarket__billing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import supermarket__billing.Data;

public class Invoice extends Cart{
	
		private double totalPrice;
		private double totalDiscountedPrice;
		private double totalDiscount;
		private List<Double> itemsDiscount;

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public double getTotalDiscountedPrice() {
			return totalDiscountedPrice;
		}

		public void setTotalDiscountedPrice(double totalDiscountedPrice) {
			this.totalDiscountedPrice = totalDiscountedPrice;
		}

		public void setTotalDiscount(double totalDiscount) {
			this.totalDiscount = totalDiscount;
		}

		public void setItemsDiscount(List<Double> itemsDiscount) {
			this.itemsDiscount = itemsDiscount;
		}
		
		public double getTotalDiscount() {
			return totalDiscount;
		}

		public List<Double> getItemsDiscount() {
			return itemsDiscount;
		}

		
		
		
		public void billCartItemsAfterDiscounts() {
			itemsDiscount = new ArrayList<>();
			cartItems.forEach(item -> {
				
				// get category of the item in cart
				Category cat=null;
				for(int i=0; i<Data.getCategories().size(); i++)
				{
					Category x=Data.getCategories().get(i);
					if(x.getName().equals(item.getCategoryname()))
					{
						cat=x;
						break;
					}
				}
				
				//get SubCategory of the item in cart
				SubCategory sub=null;
				for(int j=0; j<Data.getSubcategories().size(); j++)
				{
					SubCategory x=Data.getSubcategories().get(j);
					if(x.getName().equals(item.getSubcategoryname()))
					{
						sub=x;
						break;
					}
				}
				String dtype=item.getDiscountType();
				int q = item.getQuantity();
				double catDisc = cat.getDiscount().getDiscountAmount(item.getUnitPrice()) * q;
				double subDisc = sub.getDiscount().getDiscountAmount(item.getUnitPrice()) * q;;
				
				double itemDisc=0;
				if(dtype.equals("percentage_off"))
				{
				itemDisc= item.getDiscount().getDiscountAmount(item.getUnitPrice()) * q;
				double arr[] = { catDisc, subDisc, itemDisc };
				Arrays.sort(arr);
				itemsDiscount.add(arr[2]);
				totalDiscount += arr[2];
				
				}
				else {
					//Logic for BUY 1 Get 1
					int buy_units=item.getDiscount().getBuyUnits();
					int free=q%item.getDiscount().getMinPurchaseQty();
					int get_items=(q-free)%buy_units;
					itemDisc=get_items*item.getUnitPrice();
					itemsDiscount.add(itemDisc);
					totalDiscount += itemDisc;
				}
				totalPrice+=item.getUnitPrice()*q;
			});
			totalDiscountedPrice = totalPrice - totalDiscount;

		}

		
		public Invoice(Cart cart) {
			super(cart.getCustomerName());
			this.cartItems = cart.getCartItems();
		}

		
		@Override
		public String toString() {
			return "Invoice [totalAmount=" + totalPrice + ", totalDiscountedAmount=" + totalDiscountedPrice
					+ ", totalDiscount=" + totalDiscount + ", itemsDiscount=" + itemsDiscount + "]";
		}

}
