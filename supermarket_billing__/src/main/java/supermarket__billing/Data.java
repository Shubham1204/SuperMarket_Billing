package supermarket__billing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import supermarket__billing.model.Cart;
import supermarket__billing.model.Category;
import supermarket__billing.model.Invoice;
import supermarket__billing.model.Item;
import supermarket__billing.model.SubCategory;
import supermarket__billing.service.FileReaderService;

public class Data {
	private static List<Category> categories;
	private static List<SubCategory> subcategories;
	private static List<Item> items;
	private static Map<String, String> itemIdentifier;
	private static List<Cart> carts;
	private static Invoice invoices;
	public static List<Category> getCategories() {
		return categories;
	}
	public static void setCategories(List<Category> categories) {
		Data.categories = categories;
	}
	public static List<SubCategory> getSubcategories() {
		return subcategories;
	}
	public static void setSubcategories(List<SubCategory> subcategories) {
		Data.subcategories = subcategories;
	}
	public static List<Item> getItems() {
		return items;
	}
	public static void setItems(List<Item> items) {
		Data.items = items;
	}
	public static Map<String, String> getItemIdentifier() {
		return itemIdentifier;
	}
	public static void setItemIdentifier(Map<String, String> itemIdentifier) {
		Data.itemIdentifier = itemIdentifier;
	}
	public static List<Cart> getCarts() {
		return carts;
	}
	public static void setCarts(List<Cart> carts) {
		Data.carts = carts;
	}
	public static Invoice getInvoices() {
		return invoices;
	}
	public static void setInvoices(Invoice invoices) {
		Data.invoices = invoices;
	}
	
	public static void init(FileReaderService rs) {
		categories = rs.readCategories();
		subcategories = rs.readSubCategories();
		items = rs.readItems();
		itemIdentifier = new HashMap<String, String>();
		items.forEach((it) -> {
			itemIdentifier.put(it.getName().toLowerCase(), it.getName());
		});

	}

}
