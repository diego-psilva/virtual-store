package br.com.virtualstore.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;

@Component
public class OrderRepository {
	
	  private List<Order> orders;

	    public OrderRepository() {
	        orders = new LinkedList<>();
	    }

	    public List<Order> findAll() {
	        return Collections.unmodifiableList(orders);
	    }

	    public Order findById(int id) {
	        if (orders.stream().anyMatch(order -> order.equals(id))) {
	            return orders.stream().filter(order -> order.equals(id)).findFirst().get();
	        }
	        return new Order(0, new Client(0, ""), new LinkedList<>(), null);
	    }

	    public List<Order> findByClientId(int clientId) {
	        return orders.stream().filter(order -> order.getClientId() == clientId).collect(Collectors.toList());
	    }

	    public boolean existById(int id) {
	        return orders.stream().anyMatch(order -> order.equals(id));
	    }

	    public int getNextIdToUse() {
	        return orders.size()+1;
	    }

	    public void save(Order order) {
	        orders.add(order);
	    }

}
