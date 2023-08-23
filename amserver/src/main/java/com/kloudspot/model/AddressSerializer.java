package com.kloudspot.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class AddressSerializer extends JsonSerializer<Address> {

	@Override
	public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		// Define your custom serialization logic here
		// For example, you can write address fields to the JSON generator
		jsonGenerator.writeStartObject();
		jsonGenerator.writeStringField("street", address.getStreet());
		jsonGenerator.writeStringField("city", address.getCity());
		jsonGenerator.writeStringField("state", address.getState());
		jsonGenerator.writeStringField("country", address.getCountry());
		// Serialize other address fields
		jsonGenerator.writeEndObject();
	}
}
