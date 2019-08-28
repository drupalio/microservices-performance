package com.hazelcast.imdg.microservices;

import com.hazelcast.config.Config;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HazelcastDemo {

    @Bean
    public Config config() {
        Config config = new Config("hazelcastInstance");
        MapConfig databaseConfig = new MapConfig("database");
        config.addMapConfig(databaseConfig);
        ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
        managementCenterConfig.setEnabled(true);
        managementCenterConfig.setUrl("http://localhost:8081");
        config.setManagementCenterConfig(managementCenterConfig);
        config.setProperty("jmx.enabled", "true");
        return config;
    }

    public static void main(String[] args) {
        SpringApplication.run(HazelcastDemo.class, args);
    }
}