package br.com.virtualstore.generator.deserializer;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.virtualstore.model.Product;
public class ProductDeserializer extends JsonDeserializer<Product> {

	@Override
	public Product deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		   JsonNode node = p.getCodec().readTree(p);
	        final int id = node.get("id").asInt();
	        final String name = node.get("name").asText();
	        final double price = node.get("price").asDouble();
	        return new Product(id, name, price);
	}

}
