package io.fzyun.paas.stackservice.service.impl;

import io.fzyun.paas.stackservice.model.Bundle;
import io.fzyun.paas.stackservice.model.DockerCompose;
import io.fzyun.paas.stackservice.model.Ticket;
import io.fzyun.paas.stackservice.service.ComposeService;
import io.fzyun.paas.stackservice.service.RancherService;
import io.fzyun.paas.stackservice.service.RedmineService;
import io.fzyun.paas.stackservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BB8 implements RedmineService, TemplateService, ComposeService {

    private static final int NUMBER = 3;

    @Autowired
    RancherService rs;

    @Override
    public Ticket fetchTicket(String ticketId) { // TODO: 2018/9/13
        Ticket ticket = new Ticket();
        ticket.setInventory(template(ticketId));
        return ticket;
    }

    @Override
    public Map<String, DockerCompose> compose(String ticketId) {
        String stackId = fetchTicket(ticketId).getStackId();
        DockerCompose dockerCompose = rs.fetchDockerCompose(stackId);
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
        List<Bundle> inventory = fetchTicket(ticketId).getInventory();
        DockerCompose dc = rs.fetchDockerCompose(fetchTicket(ticketId).getStackId());

        List<String> allServiceNamesInInventory = new LinkedList<>();
        inventory.forEach(bundle -> allServiceNamesInInventory.addAll(bundle.getSvcNames()));
        Set<String> allServiceNamesInDc = dc.getServices().keySet();
        return !(allServiceNamesInInventory.retainAll(allServiceNamesInDc) || allServiceNamesInDc.retainAll(allServiceNamesInInventory));//判断两个集合是否相等
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
