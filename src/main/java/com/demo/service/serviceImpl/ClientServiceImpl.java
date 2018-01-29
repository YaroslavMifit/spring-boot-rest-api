package com.demo.service.serviceImpl;

import com.demo.repository.ClientRepository;
import com.demo.service.ClientService;
import com.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getByID(long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void remove(long id) {
        clientRepository.delete(id);
    }
}
