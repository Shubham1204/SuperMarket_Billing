package supermarket__billing.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import supermarket__billing.model.CartItem;
import supermarket__billing.model.Invoice;

public class InvoicePrint {
	
		//Method for printing the values
		public List printBills(Invoice invoice) {
			System.out.println("Customer:  "+invoice.getCustomerName());
			System.out.print("\n");
			
			List<CartItem> citems = invoice.getCartItems();
			List<Double> amounts = invoice.getItemsDiscount();
			Iterator<Double> itr = amounts.iterator();
			System.out.printf("Item\t\t\tQty\tAmount\n");
			for(CartItem citem : citems) {
				double temp = citem.getUnitPrice()*citem.getQuantity();
				double temp2 = itr.next();
				System.out.printf("%s\t\t\t%d%s\t%.2f\n",citem.getName().trim(),citem.getQuantity(),citem.getUnit(),(temp-temp2));
				
			}
			System.out.println("---------------------------------------");
			
			System.out.printf("Total Amount \t\t\t%.2f\n",invoice.getTotalDiscountedPrice());
			System.out.printf("You Saved \t%.2f %s %.2f %s %.2f %s \n",invoice.getTotalPrice(),"-",invoice.getTotalDiscountedPrice(),"=",invoice.getTotalDiscount()," Rs");
			
			List lis=new ArrayList();
			lis.add(invoice.getCustomerName());
			lis.add(invoice.getTotalPrice());
			lis.add(invoice.getTotalDiscount());
			lis.add(invoice.getTotalDiscountedPrice());
			lis.add(invoice.getCartItems());
			return lis;
	}

}
