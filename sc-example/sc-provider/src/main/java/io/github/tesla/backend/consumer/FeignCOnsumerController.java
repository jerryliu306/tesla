package io.github.tesla.backend.consumer;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign/consumer")
public class FeignCOnsumerController {

    @Autowired
    private ProviderServiceInterface providerServiceInterface;

    @RequestMapping("test")
    public String test() {
        return providerServiceInterface.test();
    }

    @RequestMapping("user")
    public String user() {
        return providerServiceInterface.user();
    }

    @RequestMapping("drools")
    public String drools() {
        return providerServiceInterface.drools();
    }
}
