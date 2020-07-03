package br.com.virtualstore.generator.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.virtualstore.model.Product;

public class ProductSerializer extends JsonSerializer<Product>{
	 @Override
	    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
	        jsonGenerator.writeStartObject();
	        jsonGenerator.writeObjectField("id", product.getId());
	        jsonGenerator.writeObjectField("name", product.getName());
	        jsonGenerator.writeObjectField("price", product.getPrice());
	        jsonGenerator.writeEndObject();
	        jsonGenerator.flush();
	        jsonGenerator.close();
	    }
}
