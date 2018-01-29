package com.demo.service;

import com.demo.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();
    Client getByID(long id);
    Client save(Client client);
    Client update(Client client);
    void remove(long id);
}
