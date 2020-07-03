package br.com.virtualstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtualstore.model.ProductHolder;
import br.com.virtualstore.repository.Store;

@Service
public class StoreService {
	
	private final Store store;

    @Autowired
    public StoreService(Store store) {
        this.store = store;
    }

    public List<ProductHolder> getStore() {
        return store.findAll();
    }

    public boolean hasEnough(int productId, int quantity) {
        return store.hasEnough(productId, quantity);
    }

    public void removeFromStore(ProductHolder productHolder) {
        store.removeFromStore(productHolder);
    }


}
