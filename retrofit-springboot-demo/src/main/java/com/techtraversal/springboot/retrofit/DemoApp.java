package com.techtraversal.springboot.retrofit;

import com.techtraversal.springboot.retrofit.autoconfigure.RetrofitClientsScan;
import com.techtraversal.springboot.retrofit.service.Contributor;
import com.techtraversal.springboot.retrofit.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import retrofit2.Call;

import java.util.List;


@SpringBootApplication
@RetrofitClientsScan(basePackages = "com.techtraversal.springboot.retrofit.service")
public class DemoApp {

    @Autowired
    @Lazy
    private GithubService githubService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Call<List<Contributor>> call = githubService
                    .contributors("square", "retrofit");
            List<Contributor> contributors = call.execute().body();

            System.out.println("List of contributors:");
            contributors.forEach(contributor ->
                    System.out.println(String.format("%s (%s)",
                            contributor.login,
                            contributor.contributions)));
        };
    }
}
