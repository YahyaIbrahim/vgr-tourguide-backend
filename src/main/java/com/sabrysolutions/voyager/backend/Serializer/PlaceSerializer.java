package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.Place;
import com.sabrysolutions.voyager.backend.models.WorkPlace;

import java.io.IOException;

public class PlaceSerializer extends StdSerializer<Place> {

    public PlaceSerializer() {
        this(null);
    }
    public PlaceSerializer(Class<Place> t) {
        super(t);
    }


    @Override
    public void serialize(
            Place value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("placeName",value.getName());
        gen.writeObjectField("City",value.getCity());
        gen.writeObjectField("placeImage",value.getImage());
        gen.writeEndObject();

    }

}
