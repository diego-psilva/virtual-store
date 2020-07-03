package br.com.virtualstore.generator.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import br.com.virtualstore.model.Client;

public class ClientDeserializer extends JsonDeserializer<Client> {

	@Override
	public Client deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
