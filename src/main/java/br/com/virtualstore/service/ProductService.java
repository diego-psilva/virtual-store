package br.com.virtualstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.virtualstore.model.Product;
import br.com.virtualstore.repository.ProductRepository;

@Service
public class ProductService {
	
	final
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public boolean hasProductById(int id) {
        return productRepository.existsById(id);
    }

    public boolean hasProductByName(String name) {
        return productRepository.existsByName(name);
    }

}
