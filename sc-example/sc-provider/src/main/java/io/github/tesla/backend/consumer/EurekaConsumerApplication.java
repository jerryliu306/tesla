package io.github.tesla.backend.consumer;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaConsumerApplication {
  public static void main(String[] args) {
    List<String> configList = Lists.newArrayList(Arrays.asList(args));
    configList.add("--spring.profiles.active=consumer");
    // configList.add("--spring.config.location=application-8099.yaml");
    SpringApplication.run(EurekaConsumerApplication.class, configList.toArray(new String[]{}));
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
