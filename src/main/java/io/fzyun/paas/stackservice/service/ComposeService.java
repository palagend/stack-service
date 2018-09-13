package io.fzyun.paas.stackservice.service;

import io.fzyun.paas.stackservice.model.DockerCompose;

import java.util.Map;

public interface ComposeService {
    Map<String, DockerCompose> compose(String ticketId);
}
