package com.training.userservice.domain;

import com.training.userservice.converter.GeoConverter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Address implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @Convert(converter = GeoConverter.class)
    private Geo geo;


}
