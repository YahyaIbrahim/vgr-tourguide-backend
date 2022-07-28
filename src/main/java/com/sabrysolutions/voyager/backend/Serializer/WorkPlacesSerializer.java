package com.sabrysolutions.voyager.backend.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.sabrysolutions.voyager.backend.models.WorkPlace;

import java.io.IOException;


public class WorkPlacesSerializer extends StdSerializer<WorkPlace> {

    public WorkPlacesSerializer() {
        this(null);
    }
    public WorkPlacesSerializer(Class<WorkPlace> t) {
        super(t);
    }


    @Override
    public void serialize(
            WorkPlace value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {

        gen.writeObject(value.getPlace());


    }

}

