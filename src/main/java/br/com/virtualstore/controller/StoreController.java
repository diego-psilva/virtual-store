package br.com.virtualstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.service.StoreService;
import br.com.virtualstore.model.ProductHolder;

@RestController
public class StoreController {
	
	 private final StoreService storeService;

	    public StoreController(StoreService storeService) {
	        this.storeService = storeService;
	    }

	    @RequestMapping(value = "/store/has", method = RequestMethod.GET)
	    public boolean hasEnough(@RequestParam int productId, @RequestParam int quantity) {
	        return storeService.hasEnough(productId, quantity);
	    }

	    @RequestMapping(value = "/store", method = RequestMethod.GET)
	    public List<ProductHolder> getStore() {
	        return storeService.getStore();
	    }

}
