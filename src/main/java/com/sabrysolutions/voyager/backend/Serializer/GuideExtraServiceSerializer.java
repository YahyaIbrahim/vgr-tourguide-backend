package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.Country;
import com.sabrysolutions.voyager.backend.models.GuideExtraService;

import java.io.IOException;


public class GuideExtraServiceSerializer extends StdSerializer<GuideExtraService> {

    public GuideExtraServiceSerializer() {
        this(null);
    }

    public GuideExtraServiceSerializer(Class<GuideExtraService> t) {
        super(t);
    }


    @Override
    public void serialize(
            GuideExtraService value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("Name",value.getExtraService().getName());
        gen.writeObjectField("Fees",value.getFees());
        gen.writeEndObject();


    }
}

