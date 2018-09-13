package io.fzyun.paas.stackservice.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * docker-compose.yml的表示类
 *
 * @author 胡月恒
 * @mail huyh@founder.com
 * @date 2018-09-12
 */
@Data
public class DockerCompose {
    String version = "2";
    Map<String, Service> services;

    public DockerCompose extract(List<String> svcNames) {
        DockerCompose dc = new DockerCompose();
        Map<String, Service> map = new HashMap<>();
        svcNames.forEach(name -> map.put(name, services.get(name)));
        dc.setServices(map);
        return dc;
    }
}
