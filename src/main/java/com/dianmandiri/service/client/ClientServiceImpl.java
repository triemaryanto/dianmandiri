package com.dianmandiri.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dianmandiri.entity.Client;
import com.dianmandiri.entity.Kelompok;
import com.dianmandiri.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Override
	public List<Client> getAllClient() {
		
		return (List<Client>) clientRepository.findAll();
	}
	
	
	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	@Override
	public Client findById(Long idClient) {
		Optional<Client> client= clientRepository.findById(idClient);

		if (client.isPresent()) {
			;
			return client.get();
		} else {
			return save(null);
		}
	}

}
