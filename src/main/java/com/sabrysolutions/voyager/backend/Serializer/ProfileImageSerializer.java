package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.sabrysolutions.voyager.backend.models.ProfileImage;

import java.io.IOException;

public class ProfileImageSerializer extends StdSerializer<ProfileImage> {
    public ProfileImageSerializer() {
        this(null);
    }
    public ProfileImageSerializer(Class<ProfileImage> t) {
        super(t);
    }


    @Override
    public void serialize(
            ProfileImage value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("path",value.getPath());
        gen.writeEndObject();

    }
}
