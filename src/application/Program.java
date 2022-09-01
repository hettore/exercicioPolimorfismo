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

		List<Product> prod = new ArrayList<>();

		System.out.print("Enter the number os products: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1)  + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (ch == 'c') {
				prod.add(new Product(name, price));
			} else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				prod.add(new UsedProduct(name, price, data));
			} else {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				prod.add(new ImportedProduct(name, price, fee));
			}

		}

		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product emp : prod) {
			System.out.println(emp.priceTag());
		}
		sc.close();
	}
}
