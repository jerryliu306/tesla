package io.github.tesla.backend.provider;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication()
@EnableDiscoveryClient
public class EurekaProviderApplication9099 {
  public static void main(String[] args) {
    List<String> configList = Lists.newArrayList(Arrays.asList(args));
    configList.add("--spring.profiles.active=9099");
    // configList.add("--spring.config.location=application-8099.yaml");
    SpringApplication.run(EurekaProviderApplication9099.class, configList.toArray(new String[]{}));
  }

}
