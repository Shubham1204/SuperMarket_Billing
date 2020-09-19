package supermarket__billing.model;

public class SubCategory extends Category {
	
	private String categoryname;

	public SubCategory(String name, String discountType, Discount discount, String categoryname) {
		super(name, discountType, discount);
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "SubCategory [categoryname=" + categoryname + ", name=" + getName() + ", discountType="
				+ getDiscountType() + ", discount=" + getDiscount() + "]";
	}

}
