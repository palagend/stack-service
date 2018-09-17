package io.fzyun.paas.stackservice.service;

import io.fzyun.paas.stackservice.model.DockerCompose;

import java.util.List;

/**
 * 与rancher应用商店交互
 *
 * @author 胡月恒
 * @mail huyh@founder.com
 * @date 2018-09-17
 */
public interface RancherService {
    DockerCompose fetchDockerCompose(String stackId);

    List<String> fetchStacks();
}
