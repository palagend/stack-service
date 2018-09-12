package io.fzyun.paas.stackservice.endpoint;

import io.fzyun.paas.stackservice.model.DockerCompose;
import io.fzyun.paas.stackservice.model.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "应用栈服务API")
public class EndpointSet {
    @GetMapping("/stacks")
    @ApiOperation("获取应用栈列表")
    public String[] stacks() {
        String[] arr = {"pdtId0-tenantId0", "pdtId1-tenantId1", "pdtId2-tenantId2"};
        return arr;
    }

    @GetMapping("/stacks/{stack-id}/config")
    @ApiOperation("获取应用栈配置文件(docker-compose.yml)")
    public DockerCompose stackConfig(@PathVariable("stack-id") String stackId) {
        DockerCompose dc = new DockerCompose();
        Service s0 = new Service();
        Service s1 = new Service();
        Service s2 = new Service();
        Map<String, Service> map = new HashMap<>();
        map.put("svc-name0", s0);
        map.put("svc-name1", s1);
        map.put("svc-name2", s2);
        Map<String, Service> svcs = map;
        dc.setServices(svcs);
        return dc;
    }
}
