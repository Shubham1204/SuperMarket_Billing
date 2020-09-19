package supermarket__billing.model;

public enum Units {
		kg("kg"), g("grams"), lt("lt"), ml("ml"), dzn("dzn");

		private String unit;

		Units(String unit) {
			this.unit = unit;
		}

		String getUnit() {
			return unit;
		}
	

}
