package com.kloudspot.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class AddressDeserializer extends JsonDeserializer<Address> {

	@Override
	public Address deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

		String street = jsonNode.get("street").asText();
		String city = jsonNode.get("city").asText();
		String country = jsonNode.get("country").asText();
		String state = jsonNode.get("state").asText();

		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		address.setState(state);

		return address;
	}
}
