package supermarket__billing.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import supermarket__billing.Data;
import supermarket__billing.exception.CartDoesNotContainParticularItem;
import supermarket__billing.exception.QuantityZeroException;
import supermarket__billing.model.Cart;
import supermarket__billing.model.CartItem;
import supermarket__billing.model.Item;

public class FileCartService {
	
	//read inputs from input.txt file
	public List<Cart> readBillFromInput(String inputfile) throws Exception  {
		List<Cart> all_cart_items = new ArrayList<>();
		String customer_name;

		Cart cart;
		BufferedReader br;
		try {
			if (inputfile != null) {
				br = new BufferedReader(new FileReader(inputfile));
			} else {
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				InputStream is = classloader.getResourceAsStream("input.txt");
				InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				br = new BufferedReader(streamReader);
			}
			String cust_string=br.readLine();
			String cust_cart=br.readLine();
				//iterate to fetch the customer name
				String cstr[]=cust_string.split(" ");
				String customer_firstname=cstr[1].trim();
				String customer_lastname=cstr[2].trim();
				customer_name=customer_firstname+" "+customer_lastname;
				cart = new Cart(customer_name);
				
				//iterate over cart to fetch the items
				String[] istr = cust_cart.split(", ");
				for (int i = 0; i < istr.length; i++) {
					String[] itstr = istr[i].split(" ");
					String itname="";
					for(int j=0; j<itstr.length-1; j++)
					{
						itname+=" "+itstr[j];
					}
					List<Item> lis=Data.getItems();
					CartItem cartItem;
					List<String> item_names=new ArrayList<>();
					for(int j=0; j<lis.size(); j++)
					{
						item_names.add(lis.get(j).getName().trim());
					}
					itname=itname.trim();
					if(!item_names.contains(itname))
					{
						throw new CartDoesNotContainParticularItem("Cart contains some item not available in supermarket.");
					}
					String unit=itstr[itstr.length-1];
					int qty=Integer.parseInt(unit.substring(0, unit.length()-2));
					if(qty==0)
					{
						throw new QuantityZeroException("There exists an item with quantity zero, Please enter correct value.");
					}
					String itemid = Data.getItemIdentifier().get(itname.toLowerCase().trim());
					List<Item> l=Data.getItems();
					for(int j=0; j<l.size(); j++)
					{
						if(l.get(j).getName().equals(itemid))
						{
							cartItem = new CartItem(qty, l.get(j));
							cart.addItem(cartItem);
						}
					}

				}

				all_cart_items.add(cart);

		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return all_cart_items;
	}

}
