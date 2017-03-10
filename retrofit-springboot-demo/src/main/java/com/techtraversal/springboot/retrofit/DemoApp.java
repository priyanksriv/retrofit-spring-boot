package com.techtraversal.springboot.retrofit;

import com.techtraversal.springboot.retrofit.autoconfigure.RetrofitClientsScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RetrofitClientsScan(basePackages = "com.techtraversal.springboot.retrofit.service")
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }
}
