package com.training.userservice.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.userservice.converter.AddressConverter;
import com.training.userservice.converter.CompanyConverter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String username;
    private String email;
    @Convert(converter = AddressConverter.class)
    private Address address;
    private String phone;
    private String website;
    @Convert(converter = CompanyConverter.class)
    private Company company;

}
