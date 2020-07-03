package br.com.virtualstore.generator.deserializer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.virtualstore.model.payment.BarCode;

public class BarCodeDeserializer extends JsonDeserializer<BarCode> {


    public BarCode deserializeBillet(JsonNode jsonNode) {
        String field1 = jsonNode.get("field1").asText();
        String field2 = jsonNode.get("field2").asText();
        String field3 = jsonNode.get("field3").asText();
        String field4 = jsonNode.get("field4").asText();
        double total = jsonNode.get("total").asDouble();
        List<String> list = new LinkedList<>();
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        BarCode barCode = new BarCode(total);
        barCode.setBarCode(list);
        return barCode;
    }

	@Override
	public BarCode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}
}