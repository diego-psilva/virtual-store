package br.com.virtualstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.service.ProductService;

@RestController
public class ProductController {
	
	 @Autowired
	    ProductService productService;

	    @RequestMapping(value = "/products", method = RequestMethod.GET)
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	    public Product getProduct(@PathVariable int id) {
	        return productService.getProductById(id);
	    }

	    @RequestMapping(value = "/products/{name}", method = RequestMethod.GET)
	    public Product getProduct(@PathVariable String name) {
	        return productService.getProductByName(name);
	    }

	    @RequestMapping(value = "/hasProduct/{id}", method = RequestMethod.GET)
	    public boolean hasProduct(@PathVariable int id) {
	        return productService.hasProductById(id);
	    }

	    @RequestMapping(value = "/products/{name)", method = RequestMethod.GET)
	    public boolean hasProduct(@PathVariable String name) {
	        return productService.hasProductByName(name);
	    }

}
