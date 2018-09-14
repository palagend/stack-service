package io.fzyun.paas.stackservice.service.impl;

import io.fzyun.paas.stackservice.model.DockerCompose;
import io.fzyun.paas.stackservice.model.Service;
import io.fzyun.paas.stackservice.service.RancherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RancherServiceImpl implements RancherService {
    @Value("rancher.access-key")
    String accessKey;
    @Value("rancher.secret-key")
    String secretKey;

    @Override
    public DockerCompose fetchDockerCompose(String stackId) {// TODO: 2018/9/13
        DockerCompose dc = new DockerCompose();
        Map<String, Service> svcMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            svcMap.put("app" + i, new Service().image("founder/gogs:latest"));
            svcMap.put("web" + i, new Service().image("founder/portal:latest"));
            svcMap.put("db" + i, new Service().image("founder/postgresql:latest"));
        }
        dc.setServices(svcMap);
        return dc;
    }

    @Override
    public List<String> fetchStacks() {// TODO: 2018/9/13
        String[] arr = {"pdtId0-tenantId0", "pdtId1-tenantId1", "pdtId2-tenantId2"};
        return Arrays.asList(arr);
    }
}
