/*
 * Copyright 2014-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.tesla.gateway.config.eureka.util;

import io.github.tesla.gateway.config.PropertyResolver;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * @author liushiming
 * @version IdUtils.java, v 0.0.1 2018年5月6日 上午10:30:03 liushiming
 */
public class IdUtils {


  private static final String SEPARATOR = ":";

  public static String getDefaultInstanceId(org.springframework.core.env.PropertyResolver resolver) {
    Properties relaxed = PropertyResolver.getProperties("spring.datasource");

//    RelaxedPropertyResolver relaxed = new RelaxedPropertyResolver(resolver);
    String vcapInstanceId = relaxed.getProperty("vcap.application.instance_id");
    if (StringUtils.hasText(vcapInstanceId)) {
      return vcapInstanceId;
    }

    String hostname = relaxed.getProperty("spring.cloud.client.hostname");
    String appName = relaxed.getProperty("spring.application.name");

    String namePart = combineParts(hostname, SEPARATOR, appName);

    String indexPart =
        relaxed.getProperty("spring.application.instance_id", relaxed.getProperty("server.port"));

    return combineParts(namePart, SEPARATOR, indexPart);
  }

  public static String combineParts(String firstPart, String separator, String secondPart) {
    String combined = null;
    if (firstPart != null && secondPart != null) {
      combined = firstPart + separator + secondPart;
    } else if (firstPart != null) {
      combined = firstPart;
    } else if (secondPart != null) {
      combined = secondPart;
    }
    return combined;
  }


}
