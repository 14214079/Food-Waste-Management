package trial.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import trial.dao.ProviderRepository;
import trial.model.Provider;



@Service
@Transactional
public class ProviderService {

	private final ProviderRepository providerRepository;

	public ProviderService(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	public List<Provider> findAll() {
		List<Provider> providers = new ArrayList<>();
		for (Provider provider : providerRepository.findAll()) {
			providers.add(provider);
		}
		return providers;
	}

	public void save(Provider provider) {
		providerRepository.save(provider);
	}

	public void delete(int id) {
		providerRepository.delete(id);
	}

	public Provider findProvider(int id) {
		return providerRepository.findOne(id);
	}
}

