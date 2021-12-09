package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private Date manufactureDate;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sbd = new StringBuilder();
		sbd.append(getName());
		sbd.append(" (used) $ ");
		sbd.append(String.format("%.2f", getPrice()));
		sbd.append(" (Manufacture date:  ");
		sbd.append(sdf.format(manufactureDate));
		sbd.append(")");
		return sbd.toString();
	}

}
