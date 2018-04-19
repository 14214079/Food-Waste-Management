package trial.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "client")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int client_id;
	private String client_name;
	private String client_company;
	private String client_contact;
	private String email;
	private String password;

	public Client() {

	}

	public Client(int client_id, String client_name, String client_company, String client_contact, String email,
			String password) {
		super();
		this.client_name = client_name;
		this.client_company = client_company;
		this.client_contact = client_contact;
		this.email = email;
		this.password = password;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_company() {
		return client_company;
	}

	public void setClient_company(String client_company) {
		this.client_company = client_company;
	}

	public String getClient_contact() {
		return client_contact;
	}

	public void setClient_contact(String client_contact) {
		this.client_contact = client_contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
