package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		String name;
		double price;

		System.out.print("Enter the number of products: ");
		int nProducts = sc.nextInt();

		for (int x = 0; x < nProducts; x++) {
			System.out.printf("Product #%d data:%n", x + 1);
			System.out.print("Common,used or imported (c/u/i)? ");
			char choice = sc.next().charAt(0);
			switch (choice) {
			case 'c':
				sc.nextLine();
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				list.add(new Product(name, price));
				break;
			case 'u':
				sc.nextLine();
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
				break;

			case 'i':
				sc.nextLine();
				System.out.print("Name: ");
				name = sc.nextLine();
				System.out.print("Price: ");
				price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
				break;
			}

		}

		System.out.println("\nPRICE TAGS:");
		for (Product e : list) {
			System.out.println(e.priceTag());
		}
		sc.close();

	}

}