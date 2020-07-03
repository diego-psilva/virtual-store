package br.com.virtualstore.repository;

import org.springframework.stereotype.Component;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.model.ShoppingCart;

@Component
public class ShoppingCartRepository {
    
	private ShoppingCart shoppingCart;

    public ShoppingCartRepository() {
        shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public double getShoppingCartTotal() {
        return shoppingCart.getTotal();
    }

    public void addProductToShoppingCart(Product product, int quantity) {
        shoppingCart.addProduct(product, quantity);
    }

    public void delProductFromShoppingCart(Product product, int quantity) {
        shoppingCart.delProduct(product, quantity);
    }
}
