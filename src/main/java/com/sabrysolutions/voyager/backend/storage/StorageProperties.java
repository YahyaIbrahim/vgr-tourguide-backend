package com.sabrysolutions.voyager.backend.storage;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE)
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
