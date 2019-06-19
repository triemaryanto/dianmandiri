package com.dianmandiri.service.client;
import java.util.List;
import com.dianmandiri.entity.Client;

public interface ClientService {

	List<Client> getAllClient();

	Client save(Client client);

	Client findById(Long idClient);

}
