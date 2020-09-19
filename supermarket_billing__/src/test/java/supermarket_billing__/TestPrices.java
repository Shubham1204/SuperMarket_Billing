package supermarket_billing__;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import supermarket__billing.Supermarket_Mainclass;

public class TestPrices {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test      //method used to check the customer name
	public void customer_Name() {
		try {
			Supermarket_Mainclass.init();
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\nameinput.txt");
			List list=Supermarket_Mainclass.generateInvoices();
			assertEquals(list.get(0), "Anish Kumar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test      //method used to check whether the total price without discount is correct or not
	public void total_Price() {
		try {
			Supermarket_Mainclass.init();
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\price.txt");
			List list=Supermarket_Mainclass.generateInvoices();
			assertEquals(list.get(1), 1860.00);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test     //method used to check whether the total discount is correct or not
	public void total_discount() {
		try {
			Supermarket_Mainclass.init();
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\price.txt");
			List list=Supermarket_Mainclass.generateInvoices();
			assertEquals(list.get(2), 376.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test    //method used to check the customer name 
	public void complete_customer_Name() {
		try {
			Supermarket_Mainclass.init();
			Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\nameinput.txt");
			List list=Supermarket_Mainclass.generateInvoices();
			assertNotEquals(list.get(0), "Ankita");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
