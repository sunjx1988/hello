package com.jxsun.solr;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {

    private static final String PROPERTIES_NAME = "solr.properties";

    public static final String SOLR_SERVER_API_KEY = "solr_server_api";

    public static final String CONNECTION_TIME_OUT_KEY = "connection_time_out";

    public static final String DEFAULT_MAX_CONNECTIONS_PER_HOST_KEY = "default_max_connections_per_host";

    public static final String MAX_TOTAL_CONNECTIONS_KEY = "max_total_connections";

    public static final String SO_TIME_OUT_KEY = "so_time_out";

    private static final Map<String, String> VALUES = new HashMap<String, String>();

    static {
        try {
            ResourceLoader loader = new DefaultResourceLoader();
            Resource resource = loader.getResource("classpath:" + PROPERTIES_NAME);
            Properties pro = new Properties();
            pro.load(resource.getInputStream());

            for (Map.Entry<Object, Object> entry : pro.entrySet()) {
                VALUES.put((String)entry.getKey(), (String)entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return VALUES.get(key);
    }
}
