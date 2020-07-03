package br.com.virtualstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;
import br.com.virtualstore.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @RequestMapping(value = "/existsClient/{id}", method = RequestMethod.GET)
    public boolean existsClient(int id) {
        return clientService.existsClient(id);
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order, @PathVariable int clientId) {
        clientService.addOrder(order, clientId);
    }

    @RequestMapping(value = "/clients/{clientId}/orders", method = RequestMethod.GET)
    public List<Order> getOrders(@PathVariable int clientId) {
        return clientService.getOrders(clientId);
    }


}
