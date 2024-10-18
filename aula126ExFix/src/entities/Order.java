package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {
	
	private LocalDate moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>(); 
	
	// Construtores da classe
	public Order() {		
	}

	public Order(LocalDate moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}
	
	// Métodos GET e SET
	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	// Métodos da classe
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	// Método toString para facilitar a visualização
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(moment + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: ");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
