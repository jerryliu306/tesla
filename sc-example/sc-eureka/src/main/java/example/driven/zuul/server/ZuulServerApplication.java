package example.driven.zuul.server;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.Arrays;
import java.util.List;


@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulServerApplication {

    public static void main(String[] args) {
        List<String> configList = Lists.newArrayList(Arrays.asList(args));
        configList.add("--spring.profiles.active=zuul");
        SpringApplication.run(ZuulServerApplication.class, configList.toArray(new String[0]));
    }
}
