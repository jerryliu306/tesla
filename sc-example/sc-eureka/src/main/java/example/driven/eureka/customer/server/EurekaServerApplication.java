package example.driven.eureka.customer.server;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Arrays;
import java.util.List;

/**
 * @author liushiming
 * @version Application.java, v 0.0.1 2018年5月7日 上午10:14:47 liushiming
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaServerApplication {
  public static void main(String[] args) throws Exception {
    List<String> configList = Lists.newArrayList(Arrays.asList(args));
    configList.add("--spring.profiles.active=eureka");
    SpringApplication.run(EurekaServerApplication.class, configList.toArray(new String[0]));
  }
}
