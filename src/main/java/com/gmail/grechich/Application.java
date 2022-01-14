package com.gmail.grechich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws URISyntaxException, SQLException {
        SpringApplication.run(Application.class, args);
//        getConnection();
    }

//    private static Connection getConnection() throws URISyntaxException, SQLException {
//        URI jdbUri = new URI("mysql://bqqg12gxioy8jvuq:z4m9ofzymtytceei@pei17y9c5bpuh987.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/km24jhwd8op8hfxc");
//
//        String username = jdbUri.getUserInfo().split(":")[0];
//        String password = jdbUri.getUserInfo().split(":")[1];
//        String port = String.valueOf(jdbUri.getPort());
//        String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
//
//        System.out.println("username:" + username);
//        System.out.println("password:" + password);
//        System.out.println("jdbUrl:" + jdbUrl);
//
//        return DriverManager.getConnection(jdbUrl, username, password);
//    }
}