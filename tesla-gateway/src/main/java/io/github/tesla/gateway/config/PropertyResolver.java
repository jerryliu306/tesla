package io.github.tesla.gateway.config;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.core.env.Environment;

import java.util.Properties;

public class PropertyResolver {

    public static Properties getProperties(String key) {
        Environment env = SpringContextHolder.getBean(Environment.class);
        Iterable<ConfigurationPropertySource> iter = ConfigurationPropertySources.get(env);

        Binder binder = new Binder(iter);
        BindResult<Properties> bindResult = binder.bind(key, Properties.class);
        return bindResult.get();
    }

    public static String getString(String key) {
        Environment env = SpringContextHolder.getBean(Environment.class);
        Iterable<ConfigurationPropertySource> iter = ConfigurationPropertySources.get(env);

        Binder binder = new Binder(iter);
        BindResult<String> bindResult = binder.bind(key, String.class);
        return bindResult.get();
    }
}
