package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Service {
    String image;
    Map<String, String> labels = new HashMap<>();

    public Service image(String image) {
        this.image = image;
        return this;
    }
}
