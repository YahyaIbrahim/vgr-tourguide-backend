package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.Tariff;
import com.sabrysolutions.voyager.backend.models.TariffSchema;

import java.io.IOException;

public class TariffSerializer extends StdSerializer<Tariff> {

    public TariffSerializer() {
        this(null);
    }
    public TariffSerializer(Class<Tariff> t) {
        super(t);
    }


    @Override
    public void serialize(
            Tariff value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeObject(value.getName());
    }

}


