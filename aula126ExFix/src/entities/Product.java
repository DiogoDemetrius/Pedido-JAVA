package entities;

public class Product {
	
	private String name;
	private double price;
	
	// Construtores da classe
	public Product() {		
	}

	public Product(String name, double price) {
		this.name = name;
		this.setPrice(price);  // Usando o setter para validar o preço
	}
	
	// Métodos GET e SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("Price cannot be negative");
		}
	}
	
	// Método toString para exibir informações do produto
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=$" + String.format("%.2f", price) + "]";
	}
}
