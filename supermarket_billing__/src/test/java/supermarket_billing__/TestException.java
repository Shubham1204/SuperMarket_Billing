package supermarket_billing__;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import supermarket__billing.Supermarket_Mainclass;
import supermarket__billing.exception.CartDoesNotContainParticularItem;
import supermarket__billing.exception.QuantityZeroException;

public class TestException {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test       //method used to check if any of the items in the cart has quantity =0
    public void quantity_zero() {
		Supermarket_Mainclass.init();
		try {
			Throwable exception = assertThrows(
					QuantityZeroException.class, () -> {
		            	Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\quantityzero.txt");		    			          
		            }
		    );
		 assertEquals("There exists an item with quantity zero, Please enter correct value.", exception.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test      //method used to check if all the items ordered present in the supermarket or not
	public void item_does_not_exist() {
		Supermarket_Mainclass.init();
		try {
			Throwable exception = assertThrows(
					CartDoesNotContainParticularItem.class, () -> {
		            	Supermarket_Mainclass.readCustomerCarts("src\\test\\resources\\wrongitem.txt");		    			          
		            }
		    );
		 assertEquals("Cart contains some item not available in supermarket.", exception.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
