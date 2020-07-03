package br.com.virtualstore.generator.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.virtualstore.model.payment.Billet;
public class BilletSerializer extends JsonSerializer<Billet>  {
	
	@Override
	    public void serialize(Billet billet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
	        jsonGenerator.writeStartObject();

	        jsonGenerator.writeFieldName("barCode");
	        BarCodeSerializer barCodeSerializer = new BarCodeSerializer();
	        jsonGenerator = barCodeSerializer.serialize2Billet(billet.getBarCode(), jsonGenerator, serializerProvider);

	        jsonGenerator.writeObjectField("total", billet.getTotal());
	        jsonGenerator.writeEndObject();
	        jsonGenerator.flush();
	        jsonGenerator.close();
	    }

}
