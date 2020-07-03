package br.com.virtualstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;
import br.com.virtualstore.model.ProductHolder;
import br.com.virtualstore.model.payment.Payment;
import br.com.virtualstore.repository.ClientRepository;
import br.com.virtualstore.service.OrderService;

@RestController
public class OrderController {
	
	 @Autowired
	    private OrderService orderService;

	    @Autowired
	    private ClientRepository clientRepository;

	    @RequestMapping(value = "/orders", method = RequestMethod.GET)
	    public List<Order> getAllClients() {
	        return orderService.getAllOrders();
	    }

	    @RequestMapping(value = "/clients/{id}/orders", method = RequestMethod.GET)
	    public List<Order> getClientOrders(@PathVariable int id) {
	        return orderService.getOrdersByClientId(id);
	    }

	    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	    public Order getOrder(@PathVariable int id) {
	        return orderService.getOrderById(id);
	    }

	    @RequestMapping(value = "/hasOrder", method = RequestMethod.GET)
	    public boolean hasOrder(@RequestParam int id) {
	        return orderService.hasOrderById(id);
	    }

	    @RequestMapping(value = "/clients/{clientId}/order", method = RequestMethod.POST)
	    public void addNewOrder(@PathVariable int clientId, @RequestBody List<ProductHolder> productHolders, @RequestBody Payment payment) {
	        Client client = clientRepository.findById(clientId);
	        int id = orderService.getNextIdToUse();
	        new Order(id, client, productHolders, payment);
	    }

}
