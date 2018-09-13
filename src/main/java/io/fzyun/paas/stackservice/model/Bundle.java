package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.List;

@Data
public class Bundle {
    String host;
    List<String> svcNames;

    public Bundle(String host, List<String> svcNames) {
        this.host = host;
        this.svcNames = svcNames;
    }

    public Bundle() {
    }
}
