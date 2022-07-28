package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;

import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.ExtraService;
import com.sabrysolutions.voyager.backend.models.GuideExtraService;

import java.io.IOException;

public class ExtraServiceSerializer extends StdSerializer<ExtraService> {

    public ExtraServiceSerializer() {
        this(null);
    }

    public ExtraServiceSerializer(Class<ExtraService> t) {
        super(t);
    }


    @Override
    public void serialize(
            ExtraService value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {

        gen.writeObjectField("Name",value.getName());


    }
}

