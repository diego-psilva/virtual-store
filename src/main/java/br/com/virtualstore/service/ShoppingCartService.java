package br.com.virtualstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.model.ShoppingCart;
import br.com.virtualstore.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	 private final ShoppingCartRepository shoppingCartRepository;

	    @Autowired
	    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
	        this.shoppingCartRepository = shoppingCartRepository;
	    }

	    public ShoppingCart getShoppingCart() {
	        return shoppingCartRepository.getShoppingCart();
	    }

	    public void addProductToShoppingCart(Product product, int quantity) {
	        shoppingCartRepository.addProductToShoppingCart(product, quantity);
	    }

	    public void delProductFromShoppingCart(Product product, int quantity) {
	        shoppingCartRepository.delProductFromShoppingCart(product, quantity);
	    }

	    public double getShoppingCartTotal() {
	        return shoppingCartRepository.getShoppingCartTotal();
	    }


}
