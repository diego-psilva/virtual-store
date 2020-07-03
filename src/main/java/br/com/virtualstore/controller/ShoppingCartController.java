package br.com.virtualstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.model.ShoppingCart;
import br.com.virtualstore.service.ProductService;
import br.com.virtualstore.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	
	@Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public ShoppingCart getShoppingCart() {
        return shoppingCartService.getShoppingCart();
    }


    @RequestMapping(value = "/shoppingCart", method = RequestMethod.PUT)
    public void addProductToShoppingCart(@RequestParam int productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        shoppingCartService.addProductToShoppingCart(product, quantity);
    }

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.DELETE)
    public void delProductFromShoppingCart(@RequestBody Product product, @RequestParam int quantity) {
        shoppingCartService.delProductFromShoppingCart(product, quantity);
    }

}
