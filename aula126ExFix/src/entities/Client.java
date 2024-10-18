package entities;

import java.util.Date;

public class Client {
	
	private String name;
	private String email;
	private Date birthDate;  // Correção: "birthDate" com "r"
	
	// Construtores da classe
	public Client() {		
	}

	public Client(String name, String email, Date birthDate) {  // Correção: "birthDate"
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;  // Correção: "birthDate"
	}
	
	// Métodos GET e SET
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {  // Correção: "birthDate"
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {  // Correção: "birthDate"
		this.birthDate = birthDate;
	}
	
}
