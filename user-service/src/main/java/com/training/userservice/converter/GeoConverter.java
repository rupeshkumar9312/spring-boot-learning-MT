package com.training.userservice.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.userservice.domain.Address;
import com.training.userservice.domain.Geo;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class GeoConverter implements AttributeConverter<Geo,String> {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Geo geo) {
        try {
            return objectMapper.writeValueAsString(geo);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public Geo convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Geo.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }
}
