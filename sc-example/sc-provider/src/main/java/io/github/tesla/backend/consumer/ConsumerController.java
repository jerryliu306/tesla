package io.github.tesla.backend.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("eureka/consumer")
public class ConsumerController {
    public static final String provider = "provider-service";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;// eureka负载均衡客户端接口

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        // return "{\"msg\":\"hello\"}";
        return restTemplate.getForObject(getProvider(provider, "/default/test"), String.class);
    }

    private String getProvider(String service, String api) {
        List<String> services = discoveryClient.getServices();
        for (String serviceStr: services) {
            System.out.println(serviceStr);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances(provider);

        ServiceInstance serviceInstance = loadBalancerClient.choose(service);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + api;
        System.out.println("url : " + url);
        return url;
    }
}
