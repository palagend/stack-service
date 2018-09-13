package io.fzyun.paas.stackservice.service;

import io.fzyun.paas.stackservice.model.Bundle;

import java.util.List;

public interface TemplateService {
    List<Bundle> template(String ticketId);

    boolean verify(String ticketId);
}
