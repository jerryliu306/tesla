package io.github.tesla.backend.consumer;

import com.google.common.collect.Lists;
import io.github.tesla.backend.provider.EurekaProviderApplication9099;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication()
@EnableDiscoveryClient
public class EurekaConsumerApplication {
  public static void main(String[] args) {
    List<String> configList = Lists.newArrayList(Arrays.asList(args));
    configList.add("--spring.profiles.active=consumer");
    // configList.add("--spring.config.location=application-8099.yaml");
    SpringApplication.run(EurekaConsumerApplication.class, configList.toArray(new String[]{}));
  }
}
