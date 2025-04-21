package org.example.service;

import org.example.dao.ClientDao;
import org.example.model.Client;

import java.util.Optional;

public class ClientCrudService {

    private final ClientDao clientDao = new ClientDao();

    public Long createClient(String name) {
        Client client = new Client();
        client.setName(name);
        clientDao.save(client);
        return client.getId();
    }

    public Optional<Client> getClient(Long id) {
        return clientDao.getById(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
