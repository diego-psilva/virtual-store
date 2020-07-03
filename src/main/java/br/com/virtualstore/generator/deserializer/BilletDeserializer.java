package br.com.virtualstore.generator.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.virtualstore.model.payment.BarCode;
import br.com.virtualstore.model.payment.Billet;

public class BilletDeserializer extends JsonDeserializer<Billet>{

	@Override
	public Billet deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		  JsonNode node = p.getCodec().readTree(p);
	        final double total = node.get("total").asDouble();
	        JsonNode barCodeNode = node.get("barCode");
	        BarCodeDeserializer barCodeDeserializer = new BarCodeDeserializer();
	        BarCode barCode = barCodeDeserializer.deserializeBillet(barCodeNode);
	        Billet billet = new Billet(total);
	        billet.setBarCode(barCode);

	        return billet;
	    }
	
	
	
}




