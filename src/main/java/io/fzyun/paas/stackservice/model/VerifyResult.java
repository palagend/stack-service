package io.fzyun.paas.stackservice.model;

import lombok.Data;

@Data
public class VerifyResult {
    boolean success;
    String msg;
}
