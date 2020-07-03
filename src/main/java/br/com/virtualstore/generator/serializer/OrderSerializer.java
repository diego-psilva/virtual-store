package br.com.virtualstore.generator.serializer;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.virtualstore.model.Order;

public class OrderSerializer extends JsonDeserializer<Order> {

	@Override
	public Order deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
