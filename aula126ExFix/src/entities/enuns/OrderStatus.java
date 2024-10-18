package entities.enuns;

public enum OrderStatus {
	PENDING_PAYMENT("Pending Payment"),
	PROCESSING("Processing"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered");

	private String description;
	
	// Construtor para associar a descrição
	private OrderStatus(String description) {
		this.description = description;
	}

	// Método para retornar a descrição
	public String getDescription() {
		return description;
	}
}
