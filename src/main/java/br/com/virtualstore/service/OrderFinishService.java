package br.com.virtualstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;
import br.com.virtualstore.model.ProductHolder;
import br.com.virtualstore.model.ShoppingCart;
import br.com.virtualstore.model.payment.Payment;

@Service
public class OrderFinishService {
	
	private final StoreService storeService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public OrderFinishService(StoreService storeService, OrderService orderService, ShoppingCartService shoppingCartService) {
        this.storeService = storeService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }


    public void finish(Client client, Payment payment) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart();
        List<ProductHolder> productHolders = shoppingCart.getProductHolders();
        int id = orderService.getNextIdToUse();
        Order order = new Order(id, client, productHolders, payment);
        orderService.addOrderToRepository(order);
        client.addOrder(order);
        shoppingCart.clear();
        productHolders.forEach(storeService::removeFromStore);


    }


}
