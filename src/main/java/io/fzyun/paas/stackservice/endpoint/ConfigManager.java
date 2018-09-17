package io.fzyun.paas.stackservice.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigManager {
    @GetMapping("/config")
    public String getConfig() {// TODO: 2018/9/17
        return null;
    }

    @PutMapping("config")
    public void putConfig() {// TODO: 2018/9/17
        return;
    }
}
