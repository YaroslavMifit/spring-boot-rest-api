package com.demo.service;

import com.demo.model.Client;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ClientService {

    List<Client> getAll(Client client, Sort sort);
    Client getByID(long id);
    Client save(Client client);
    Client update(Client client);
    void remove(long id);
}
