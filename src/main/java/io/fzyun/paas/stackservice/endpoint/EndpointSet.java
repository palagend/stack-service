package io.fzyun.paas.stackservice.endpoint;

import io.fzyun.paas.stackservice.model.DockerCompose;
import io.fzyun.paas.stackservice.model.Response;
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
@RequestMapping("/v1")
@Api(tags = "应用栈服务API")
public class EndpointSet {
    @GetMapping("/stacks")
    @ApiOperation("获取应用栈列表")
    public Response stacks() {
        String[] arr = {"pdtId0-tenantId0", "pdtId1-tenantId1", "pdtId2-tenantId2"};
        return Response.success(arr);
    }

    @GetMapping("/stacks/config/{ticket-id}")
    @ApiOperation("获取应用栈配置文件(docker-compose.yml)")
    public Response stackConfig(@PathVariable("ticket-id") String ticketId) {
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
        return Response.success(dc);
    }

    @GetMapping("/stacks/template/{ticket-id}")
    @ApiOperation("生成应用栈配置清单模板")
    public Response inventoryTemplate(@PathVariable("ticket-id") String ticketId) {
        return null;// TODO: 2018/9/13
    }

    @GetMapping("/stacks/verify/{ticket-id}")
    @ApiOperation("验证部署清单文件")
    public Response verify(@PathVariable("ticket-id") String tikcketId) {
        return Response.success("verified");
    }

    @GetMapping("/stacks/compose/{ticket-id}")
    @ApiOperation("合成DC部署配置文件")
    public Response compose(@PathVariable("ticket-id") String ticketId) {
        DockerCompose dc0 = getDockerCompose(0);
        DockerCompose dc1 = getDockerCompose(1);
        DockerCompose dc2 = getDockerCompose(1);
        Map<String, DockerCompose> map = new HashMap<>();
        map.put("192.168.1.10", dc0);
        map.put("192.168.1.11", dc1);
        map.put("192.168.1.12", dc2);
        return Response.success(map);
    }

    private DockerCompose getDockerCompose(int idx) {
        DockerCompose dc = new DockerCompose();
        Map<String, Service> map = new HashMap<>();
        Service svc0 = new Service();
        map.put("app" + idx, svc0);
        dc.setServices(map);
        return dc;
    }

}
