package trial.dao;

import trial.model.Client;

public interface CustomClientRepository<Client, String> {
	public Client findByEmail(String email);
}
