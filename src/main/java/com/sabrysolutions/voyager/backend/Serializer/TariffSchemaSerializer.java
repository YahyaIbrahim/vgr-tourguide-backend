package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.sabrysolutions.voyager.backend.models.TariffSchema;

import java.io.IOException;


public class TariffSchemaSerializer extends StdSerializer<TariffSchema> {

    public TariffSchemaSerializer() {
        this(null);
    }
    public TariffSchemaSerializer(Class<TariffSchema> t) {
        super(t);
    }


    @Override
    public void serialize(
            TariffSchema value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("Tariff Schema",value.getTariff());
        gen.writeObjectField("Cost",value.getCost());
        gen.writeEndObject();

    }

}

