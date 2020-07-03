package br.com.virtualstore.generator.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.virtualstore.model.Client;
import br.com.virtualstore.model.Order;

public class ClientSerializer extends JsonSerializer<Client>{
	
	@Override
    public void serialize(Client client, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        List<Order> orders = client.getOrders();
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("id", client.getId());
        jsonGenerator.writeObjectField("name", client.getName());
        jsonGenerator.writeFieldName("orders");
        jsonGenerator.writeStartArray();



        orders.forEach(
                order -> {
                    try {
                        jsonGenerator.writeObject(order);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();

        jsonGenerator.flush();
        jsonGenerator.close();
    }

    public JsonGenerator serialize2Order(Client client, JsonGenerator jsonGenerator) {

        return jsonGenerator;
    }
}
