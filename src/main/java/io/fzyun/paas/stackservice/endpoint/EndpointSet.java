package io.fzyun.paas.stackservice.endpoint;

import io.fzyun.paas.stackservice.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/stacks/{stack-id}/template")
    @ApiOperation("生成应用栈配置清单模板(???还有疑问)")
    public InventoryTemplate inventoryTemplate(@PathVariable("stack-id") String stackId) {
        return null;// TODO: 2018/9/13
    }

    @PostMapping("/stacks/verify")
    @ApiOperation("验证部署清单文件")
    public VerifyResult verify(@RequestBody Inventory inventory) {
        return new VerifyResult();
    }

    @PostMapping("/stacks/{stack-id}/compose")
    @ApiOperation("合成DC部署配置文件")
    public List<DockerCompose> compose(@PathVariable("stack-id") String stackId) {
        ArrayList<DockerCompose> lst = new ArrayList<>();
        DockerCompose dc0 = getDockerCompose(0);
        DockerCompose dc1 = getDockerCompose(1);
        DockerCompose dc2 = getDockerCompose(1);
        lst.add(dc0);
        lst.add(dc1);
        lst.add(dc2);
        return lst;
    }

    private DockerCompose getDockerCompose(int idx) {
        DockerCompose dc = new DockerCompose();
        Map<String, Service> map = new HashMap<>();
        Service svc0 = new Service();
        Map<String, String> labels = new HashMap<>();
        labels.put("host", "192.168.1." + idx);
        svc0.setLabels(labels);
        map.put("app" + idx, svc0);
        dc.setServices(map);
        return dc;
    }

}
