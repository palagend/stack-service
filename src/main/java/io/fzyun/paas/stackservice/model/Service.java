package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Service {
    String image;
    Map<String, String> labels = new HashMap<>();
}
