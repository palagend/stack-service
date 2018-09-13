package io.fzyun.paas.stackservice.service.impl;

import io.fzyun.paas.stackservice.model.Bundle;
import io.fzyun.paas.stackservice.model.DockerCompose;
import io.fzyun.paas.stackservice.model.Service;
import io.fzyun.paas.stackservice.model.Ticket;
import io.fzyun.paas.stackservice.service.ComposeService;
import io.fzyun.paas.stackservice.service.RancherService;
import io.fzyun.paas.stackservice.service.RedmineService;
import io.fzyun.paas.stackservice.service.TemplateService;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * <p>名字取自《星球大战》中的机器人BB-8</p>
 * <p>全能手</p>
 *
 * @author 胡月恒
 * @mail huyh@founder.com
 * @date 2018-09-13
 */
@Component
public class BB8 implements RancherService, RedmineService, TemplateService, ComposeService {

    private static final int NUMBER = 3;

    @Override
    public DockerCompose fetchDockerCompose(String stackId) {// TODO: 2018/9/13
        DockerCompose dc = new DockerCompose();
        Map<String, Service> svcMap = new HashMap<>();
        for (int i = 0; i < NUMBER; i++) {
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

    @Override
    public Ticket getTicket(String ticketId) {
        return new Ticket();// TODO: 2018/9/13
    }

    @Override
    public Map<String, DockerCompose> compose(String ticketId) {
        String stackId = getTicket(ticketId).getStackId();
        DockerCompose dockerCompose = fetchDockerCompose(stackId);
        List<Bundle> template = template(ticketId);
        return merge(dockerCompose, template);
    }

    @Override
    public List<Bundle> template(String ticketId) {// TODO: 2018/9/13
        List<Bundle> bundles = new ArrayList<>();
        for (int i = 0; i < NUMBER; i++) {
            bundles.add(new Bundle("192.168.1." + i, Arrays.asList("app" + i, "web" + i, "db" + i)));
        }
        return bundles;

    }

    @Override
    public boolean verify(String ticketId) {
        List<Bundle> inventory = getTicket(ticketId).getInventory();
        DockerCompose dc = fetchDockerCompose(getTicket(ticketId).getStackId());

        List<String> allServiceNamesInInventory = new LinkedList<>();
        inventory.forEach(bundle -> allServiceNamesInInventory.addAll(bundle.getSvcNames()));
        return !(allServiceNamesInInventory.retainAll(dc.getServices().values()) || dc.getServices().values().retainAll(allServiceNamesInInventory));//判断两个集合是否相等
    }

    private Map<String, DockerCompose> merge(DockerCompose dockerCompose, List<Bundle> bundles) {
        Map<String, DockerCompose> map = new HashMap<>();
        bundles.forEach(bundle -> {
            DockerCompose dc = dockerCompose.extract(bundle.getSvcNames());
            map.put(bundle.getHost(), dc);
        });
        return map;
    }
}
