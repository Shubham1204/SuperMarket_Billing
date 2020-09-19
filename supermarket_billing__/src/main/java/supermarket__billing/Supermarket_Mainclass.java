package supermarket__billing;

import java.io.IOException;
import java.util.List;

import supermarket__billing.model.Cart;
import supermarket__billing.model.Invoice;
import supermarket__billing.service.FileCartService;
import supermarket__billing.service.FileReaderService;
import supermarket__billing.service.InvoicePrint;

public class Supermarket_Mainclass {
	
	
	public static void main(String[] args) {
		try {
			init();
			String filename = null;
			readCustomerCarts(filename); 
			generateInvoices();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static List generateInvoices() {
			Invoice invoice = new Invoice(Data.getCarts().get(0));
			invoice.billCartItemsAfterDiscounts();
			Data.setInvoices(invoice);
			InvoicePrint bps = new InvoicePrint();
			return bps.printBills(Data.getInvoices());
	}


	public static void readCustomerCarts(String inputfile) throws Exception {
		FileCartService file_cart = new FileCartService();
		List<Cart> list_cart=file_cart.readBillFromInput(inputfile);
		Data.setCarts(list_cart);
	}

	
	// method used to read the data from categories, subcategories and items from csv file 
	public static void init() {
		FileReaderService rs = new FileReaderService();
		Data.init(rs);
	}


}
