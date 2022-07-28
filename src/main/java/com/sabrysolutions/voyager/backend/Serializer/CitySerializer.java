package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.City;
import com.sabrysolutions.voyager.backend.models.Country;

import java.io.IOException;

public class CitySerializer extends StdSerializer<City> {

    public CitySerializer() {
        this(null);
    }
    public CitySerializer(Class<City> t) {
        super(t);
    }


    @Override
    public void serialize(
            City value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("cityName",value.getName());
        gen.writeObjectField("Country",value.getCountry());
        gen.writeObjectField("cityImage",value.getImage());
        gen.writeEndObject();
    }
    }


