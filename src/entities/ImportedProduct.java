package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public double totalPrice(double customsFee) {
		price += +customsFee;
		return price;
	}

	@Override
	public String priceTag() {
		StringBuilder sbd = new StringBuilder();
		sbd.append(getName());
		sbd.append(" $ ");
		sbd.append(String.format("%.2f", totalPrice(customsFee)));
		sbd.append(" (Customs fee : $ ");
		sbd.append(String.format("%.2f", getCustomsFee()));
		sbd.append(")");
		return sbd.toString();
	}

}
