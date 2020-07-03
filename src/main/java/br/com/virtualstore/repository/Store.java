package br.com.virtualstore.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.model.ProductHolder;

@Component
public class Store {
	
	private final ProductRepository productRepository;

    private List<ProductHolder> productHolders;

    @Autowired
    public Store(ProductRepository productRepository) {
        productHolders = new LinkedList<>();
        putInStore(new ProductHolder(productRepository.findById(1), 20));
        putInStore(new ProductHolder(productRepository.findById(2), 20));
        putInStore(new ProductHolder(productRepository.findById(3), 20));
        this.productRepository = productRepository;
    }

    public List<ProductHolder> findAll() {
        return Collections.unmodifiableList(productHolders);
    }

    public boolean hasEnough(int productId, int quantity) {
        Optional<ProductHolder> productHolderOpt = productHolders.stream().filter(productHolder -> productHolder.getProductId() == productId).findFirst();
        if (productHolderOpt.isPresent()) {
            ProductHolder productHolder = productHolderOpt.get();
            if (productHolder.getQuantity() >= quantity) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void removeFromStore(ProductHolder prodHoldToRemove) {
        productHolders.stream()
        .filter(prodHold -> prodHold.equals(prodHoldToRemove))
        .findFirst().get().decreaseFromQuantity(prodHoldToRemove.getQuantity());
    }

    private void putInStore(ProductHolder productHolder) {
        productHolders.add(productHolder);
    }

    private void defaultStore() {
        if (productRepository != null) {
            System.out.printf("IT IS NULLL");
            if (productRepository.findById(1) != null) {
                Product product = productRepository.findById(1);
                putInStore(new ProductHolder(productRepository.findById(1), 20));
                putInStore(new ProductHolder(productRepository.findById(2), 20));
                putInStore(new ProductHolder(productRepository.findById(3), 20));
            }
        }
        Product product = productRepository.findById(1);
        putInStore(new ProductHolder(productRepository.findById(1), 20));
        putInStore(new ProductHolder(productRepository.findById(2), 20));
        putInStore(new ProductHolder(productRepository.findById(3), 20));

    }

}
