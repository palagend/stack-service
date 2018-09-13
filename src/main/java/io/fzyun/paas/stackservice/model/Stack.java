package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Stack {
    String name;
    List<Service> services;
}
