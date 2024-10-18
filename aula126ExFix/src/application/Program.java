package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = sdf.parse(sc.next());

		Client client = new Client(clientName, clientEmail, clientBirth);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		System.out.print("How many items to this order? ");
		Integer productsQuantity = sc.nextInt();

		Order order = new Order(LocalDate.now(), OrderStatus.valueOf(orderStatus));

		for (int i = 1; i <= productsQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();  
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();

			// Criação de OrderItem com o produto correto
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			order.addItem(orderItem);
		}

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + LocalDate.now());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail());
		System.out.println("Order items:");

		// Exibir os itens do pedido conforme o formato solicitado
		for (OrderItem item : order.getItems()) {
			System.out.println(item.getProduct().getName() + ", $" + String.format("%.2f", item.getPrice()) +
					", Quantity: " + item.getQuantity() + 
					", Subtotal: $" + String.format("%.2f", item.subTotal()));
		}

		System.out.println("Total price: $" + String.format("%.2f", order.total()));

		sc.close();
	}
}
