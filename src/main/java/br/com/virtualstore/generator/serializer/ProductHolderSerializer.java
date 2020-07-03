package br.com.virtualstore.generator.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.virtualstore.model.ProductHolder;

public class ProductHolderSerializer extends JsonSerializer<ProductHolder> {
   
	@Override
    public void serialize(ProductHolder productHolder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("productId", productHolder.getProductId());
        jsonGenerator.writeObjectField("quantity", productHolder.getQuantity());
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }
}
