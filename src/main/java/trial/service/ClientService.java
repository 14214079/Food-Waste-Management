package trial.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trial.dao.ClientRepository;
import trial.model.Client;

@Service
@Transactional
public class ClientService {

	@Autowired
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();
		for (Client client : clientRepository.findAll()) {
			clients.add(client);
		}
		return clients;
	}

	public void save(Client client) {
		clientRepository.save(client);
	}

	public void delete(int id) {
		clientRepository.delete(id);
	}

	public Client findClient(int id) {
		return clientRepository.findOne(id);
	}
	
	public Client findEmail(String email) {
		return clientRepository.findByEmail(email);
		//return clientRepository.findOne(id);
	}
}
