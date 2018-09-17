package com.homecare;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhao
 */

@SpringBootApplication
@EnableConfigServer
public class HomecareConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomecareConfigClientApplication.class, args);
    }
}
