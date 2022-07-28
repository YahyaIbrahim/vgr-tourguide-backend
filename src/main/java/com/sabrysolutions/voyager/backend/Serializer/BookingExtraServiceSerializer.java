package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sabrysolutions.voyager.backend.models.BookingExtraService;
import com.sabrysolutions.voyager.backend.models.ExtraService;

import java.io.IOException;

public class BookingExtraServiceSerializer extends StdSerializer<BookingExtraService> {

    public BookingExtraServiceSerializer() {
        this(null);
    }

    public BookingExtraServiceSerializer(Class<BookingExtraService> t) {
        super(t);
    }


    @Override
    public void serialize(
            BookingExtraService value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("Name",value.getServiceId().getName());
        gen.writeObjectField("Cost",value.getServiceCost());
        gen.writeEndObject();

    }
}

