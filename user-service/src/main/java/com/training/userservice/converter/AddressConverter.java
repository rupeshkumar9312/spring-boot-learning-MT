package com.training.userservice.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.userservice.domain.Address;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class AddressConverter implements AttributeConverter<Address,String> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(Address o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public Address convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Address.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }
}
