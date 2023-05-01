package com.swarawan.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppConfigTest {

    @Autowired
    AppConfig appConfig;

    @Test
    public void getAppConfig() {
        Assertions.assertNotNull(appConfig);
        Assertions.assertNotNull(appConfig.getApplicationName());
        Assertions.assertNotNull(appConfig.getBrandMobil());
        Assertions.assertNotNull(appConfig.getStudents());
        Assertions.assertNotNull(appConfig.getDatabase());
        Assertions.assertNotNull(appConfig.getSecurity());

        Assertions.assertEquals(appConfig.getApplicationName(), "Kodok Bengek");

        Assertions.assertEquals(appConfig.getStudents().get("student1"), "John Doe");
        Assertions.assertEquals(appConfig.getStudents().get("student2"), "Jane Doe");
        Assertions.assertEquals(appConfig.getStudents().get("student3"), "Fulan Bin Fulan");

        Assertions.assertEquals(appConfig.getBrandMobil().get(0), "Honda");
        Assertions.assertEquals(appConfig.getBrandMobil().get(1), "Toyota");
        Assertions.assertEquals(appConfig.getBrandMobil().get(2), "Daihatsu");
        Assertions.assertEquals(appConfig.getBrandMobil().get(3), "Subaru");

        Assertions.assertEquals(appConfig.getDatabase().getUrl(), "http://localhost:3306");
        Assertions.assertEquals(appConfig.getDatabase().getUsername(), "dbuser");
        Assertions.assertEquals(appConfig.getDatabase().getPassword(), "empty-password");

        Assertions.assertEquals(appConfig.getSecurity().getKey(), "xyz666");
        Assertions.assertEquals(appConfig.getSecurity().getSecret(), "popow999");
    }
}