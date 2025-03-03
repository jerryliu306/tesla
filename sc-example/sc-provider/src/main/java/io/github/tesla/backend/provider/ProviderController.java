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
package io.github.tesla.backend.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liushiming
 * @version BackEndController.java, v 0.0.1 2018年4月24日 上午11:51:00 liushiming
 */
@RestController
@RequestMapping("default")
public class ProviderController {


  @RequestMapping(value = "test", method = {RequestMethod.POST, RequestMethod.GET})
  public String setterMessage1() {
    System.out.println("test api");
    String json = "{\"name\": \"test\",\"phone\": \"18616705342\"}";
    return json;
  }

  @RequestMapping(value = "user", method = {RequestMethod.POST, RequestMethod.GET})
  public String user() {
    String json = "{\"name\": \"test\",\"phone\": \"18616705342\"}";
    return json;
  }

  @RequestMapping(value = "drools", method = {RequestMethod.POST, RequestMethod.GET})
  public String drools() {
    String json = "{\"name\": \"test\",\"phone\": \"18616705342\"}";
    return json;
  }
}
