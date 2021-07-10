package io.github.tesla.backend.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        discoveryClient.getServices();

        return "{\"msg\":\"hello\"}";
    }
}
