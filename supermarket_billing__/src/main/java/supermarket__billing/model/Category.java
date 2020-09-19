package supermarket__billing.model;

public class Category {
	private String name;
	private String discountType;
	private Discount discount;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Category(String name, String discountType, Discount discount) {
		super();
		this.name = name;
		this.discountType = discountType;
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", discountType=" + discountType + ", discount=" + discount
				+ "]";
	}
	

}
