package com.fil.springbasic.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseService {
//    @Value("${database.name}")
    private String name;

//    @Value("${database.port}")
    private int port;

//    @Value("${database.username}")
    private String username;

//    @Value("${database.serviceid}")
    private String serviceid;


//    public DatabaseService(@Value("${database.name}") String databaseName) {
//        this.name = databaseName;
//    }

//    public String getDatabaseName() {
//        return name;
//    }
//
//    public void setDatabaseName(String databaseName) {
//        this.name = databaseName;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }
}


