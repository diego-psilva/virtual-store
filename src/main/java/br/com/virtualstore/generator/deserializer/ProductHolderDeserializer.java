package br.com.virtualstore.generator.deserializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.virtualstore.model.ProductHolder;
import br.com.virtualstore.repository.ProductRepository;
import br.com.virtualstore.model.Product;;

public class ProductHolderDeserializer extends JsonDeserializer<ProductHolder>{
	
    @Autowired
    private ProductRepository productRepository;

	@Override
	public ProductHolder deserialize(JsonParser p, DeserializationContext ctxt)throws IOException, JsonProcessingException {
		  	JsonNode node = p.getCodec().readTree(p);
	        int productId = node.get("productId").asInt();
	        int quantity = node.get("quantity").asInt();
	        Product product = productRepository.findById(productId);
	        return new ProductHolder(product, quantity);
	}

}
