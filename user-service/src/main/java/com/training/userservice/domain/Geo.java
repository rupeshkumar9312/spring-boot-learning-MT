package com.training.userservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Geo implements Serializable {

    private String lat;
    private String lng;

}
