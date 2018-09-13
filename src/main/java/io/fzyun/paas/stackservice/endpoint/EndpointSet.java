package io.fzyun.paas.stackservice.endpoint;

import io.fzyun.paas.stackservice.model.Bundle;
import io.fzyun.paas.stackservice.model.Response;
import io.fzyun.paas.stackservice.service.ComposeService;
import io.fzyun.paas.stackservice.service.RancherService;
import io.fzyun.paas.stackservice.service.RedmineService;
import io.fzyun.paas.stackservice.service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(tags = "应用栈服务API")
public class EndpointSet {
    @Autowired
    private TemplateService templateService;
    @Autowired
    private RedmineService redmineService;
    @Autowired
    private RancherService rancherService;
    @Autowired
    private ComposeService composeService;

    @GetMapping("/stacks")
    @ApiOperation("获取应用栈列表")
    public Response stacks() {
        return Response.success(rancherService.fetchStacks());
    }

    @GetMapping("/stacks/config/{ticket-id}")
    @ApiOperation("获取应用栈配置文件")
    public Response stackConfig(@PathVariable("ticket-id") String ticketId) {
        String stackId = redmineService.fetchTicket(ticketId).getStackId();
        return Response.success(rancherService.fetchDockerCompose(stackId));
    }

    @GetMapping("/stacks/template/{ticket-id}")
    @ApiOperation("生成应用栈配置清单模板")
    public Response inventoryTemplate(@PathVariable("ticket-id") String ticketId) {
        List<Bundle> lst = templateService.template(ticketId);
        return Response.success(lst);
    }

    @GetMapping("/stacks/verify/{ticket-id}")
    @ApiOperation("验证部署清单文件")
    public Response verify(@PathVariable("ticket-id") String ticketId) {
        if (templateService.verify(ticketId)) {
            return Response.success(templateService.verify(ticketId));
        } else return Response.fail(-1, "fail");
    }

    @GetMapping("/stacks/compose/{ticket-id}")
    @ApiOperation("合成DC部署配置文件")
    public Response compose(@PathVariable("ticket-id") String ticketId) {
        return Response.success(composeService.compose(ticketId));
    }
}
