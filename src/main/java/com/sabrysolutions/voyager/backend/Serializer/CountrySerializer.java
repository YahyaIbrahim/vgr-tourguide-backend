package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.Country;

import java.io.IOException;

public class CountrySerializer extends StdSerializer<Country> {

    public CountrySerializer() {
        this(null);
    }
    public CountrySerializer(Class<Country> t) {
        super(t);
    }


    @Override
    public void serialize(
            Country value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("countryName",value.getCountryName());
        gen.writeObjectField("countryImage",value.getImage());
        gen.writeEndObject();


    }

}