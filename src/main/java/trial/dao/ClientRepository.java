package trial.dao;

import org.springframework.data.repository.CrudRepository;

import trial.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>, CustomClientRepository<Client, String> {
	public Client findByEmail(String email);
}
