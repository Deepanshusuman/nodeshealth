package com.nodeskvpn.showdetails.DetailsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.setProperty("server.port", "9000");
        //System.getProperties().put( "server.port", 8081 );
        SpringApplication.run(Main.class, args);
    }




}
