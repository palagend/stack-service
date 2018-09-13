package io.fzyun.paas.stackservice.service;

import io.fzyun.paas.stackservice.model.DockerCompose;

import java.util.List;

public interface RancherService {
    DockerCompose fetchDockerCompose(String stackId);

    List<String> fetchStacks();
}
