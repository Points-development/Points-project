package com.huiyong.model.user;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyPasswordSerializer extends JsonSerializer<String>{

	@Override
	public void serialize(String password, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		//Do nothing since we do not want to show password
		jsonGenerator.writeString("*");
	}

}
