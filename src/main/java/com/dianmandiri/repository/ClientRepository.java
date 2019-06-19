package com.dianmandiri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dianmandiri.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	
}
