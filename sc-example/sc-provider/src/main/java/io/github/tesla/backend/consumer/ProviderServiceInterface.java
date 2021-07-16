package io.github.tesla.backend.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("provider-service")
public interface ProviderServiceInterface {

    @RequestMapping("/default/test")
    String test();

    @RequestMapping("/default/user")
    String user();

    @RequestMapping("/default/drools")
    String drools();
}
