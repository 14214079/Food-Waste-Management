package trial.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="provider")
public class Provider implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int provider_id;
	private String provider_name;
	private String provider_organization;
	private String provider_contact;
	private String provider_email;
	private String provider_password;

	public Provider() {

	}

	public Provider(String provider_name, String provider_organization, String provider_contact,
			String provider_email, String provider_password) {
		super();
		this.provider_name = provider_name;
		this.provider_organization = provider_organization;
		this.provider_contact = provider_contact;
		this.provider_email = provider_email;
		this.provider_password = provider_password;
	}

	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public String getProvider_organization() {
		return provider_organization;
	}

	public void setProvider_organization(String provider_organization) {
		this.provider_organization = provider_organization;
	}

	public String getProvider_contact() {
		return provider_contact;
	}

	public void setProvider_contact(String provider_contact) {
		this.provider_contact = provider_contact;
	}

	public String getProvider_email() {
		return provider_email;
	}

	public void setProvider_email(String provider_email) {
		this.provider_email = provider_email;
	}

	public String getProvider_password() {
		return provider_password;
	}

	public void setProvider_password(String provider_password) {
		this.provider_password = provider_password;
	}

}
