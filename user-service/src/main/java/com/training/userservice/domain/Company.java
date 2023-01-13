package com.training.userservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Company implements Serializable {

    private String name;
    private String catchPhrase;
    private String bs;


}
