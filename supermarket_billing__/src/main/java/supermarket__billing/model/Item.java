package supermarket__billing.model;

public class Item {
	
	    private String name;
	    private double unitPrice;
	    private Units unit;
	    private String discountType;
	    private Discount discount;
	    private String subcategoryname;
	    private String categoryname;
	    
	    public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public double getUnitPrice() {
			return unitPrice;
		}


		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}


		public Units getUnit() {
			return unit;
		}


		public void setUnit(Units unit) {
			this.unit = unit;
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


		public String getSubcategoryname() {
			return subcategoryname;
		}


		public void setSubcategoryname(String subcategoryname) {
			this.subcategoryname = subcategoryname;
		}


		public String getCategoryname() {
			return categoryname;
		}


		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}


		public Item(String name, double unitPrice, Units unit, String discountType, Discount discount,
				  String subcategoryname, String categoryname) {
			super();
			this.name = name;
			this.unitPrice = unitPrice;
			this.unit = unit;
			this.discountType = discountType;
			this.discount = discount;
			this.subcategoryname=subcategoryname;
			this.categoryname=categoryname;
			
		}

		
		@Override
		public String toString() {
			return "Item [name=" + name + ", unitPrice=" + unitPrice + ", unit=" + unit + ", discountType="
					+ discountType + ", discount=" + discount + ", subcategoryname=" + subcategoryname + ", categoryId="
					+ categoryname + "]";
		}

}
