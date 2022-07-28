package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.Language;

import java.io.IOException;

public class LanguageSerializer extends StdSerializer<Language> {

    public LanguageSerializer() {
        this(null);
    }
    public LanguageSerializer(Class<Language> t) {
        super(t);
    }


    @Override
    public void serialize(
            Language value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeObject(value.getName());


    }
}
