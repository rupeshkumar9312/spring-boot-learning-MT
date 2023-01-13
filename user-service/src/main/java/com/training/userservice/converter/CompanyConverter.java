package com.training.userservice.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.userservice.domain.Address;
import com.training.userservice.domain.Company;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class CompanyConverter implements AttributeConverter<Company,String> {
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(Company o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException ex) {
            return null;
            // or throw an error
        }
    }

    @Override
    public Company convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Company.class);
        } catch (IOException ex) {
            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
            return null;
        }
    }
}
