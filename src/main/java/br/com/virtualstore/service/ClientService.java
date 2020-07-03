package br.com.virtualstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;
import br.com.virtualstore.repository.ClientRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) {
        return clientRepository.findById(id);
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public boolean existsClient(int id) {
        return clientRepository.existsById(id);
    }

    public void addOrder(Order order, int clientId) {
        getClient(clientId).addOrder(order);
    }

    public List<Order> getOrders(int clientId) {
        return getClient(clientId).getOrders();
    }

}
