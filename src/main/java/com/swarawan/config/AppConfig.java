package com.swarawan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "appconfig")
public class AppConfig {

    private String applicationName;
    private Map<String, String> students;
    private List<String> brandMobil;
    private AppConfigDatabase database;
    private AppConfigSecurity security;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Map<String, String> getStudents() {
        return students;
    }

    public void setStudents(Map<String, String> students) {
        this.students = students;
    }

    public List<String> getBrandMobil() {
        return brandMobil;
    }

    public void setBrandMobil(List<String> brandMobil) {
        this.brandMobil = brandMobil;
    }

    public AppConfigDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppConfigDatabase database) {
        this.database = database;
    }

    public AppConfigSecurity getSecurity() {
        return security;
    }

    public void setSecurity(AppConfigSecurity security) {
        this.security = security;
    }
}
