package com.techtraversal.springboot.retrofit;

import com.techtraversal.springboot.retrofit.service.Contributor;
import com.techtraversal.springboot.retrofit.service.GithubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApp.class })
public class BasicIntegrationTest {

    @Autowired
    private GithubService githubService;

    @Test
    public void githubTest() throws IOException {
        Call<List<Contributor>> call = githubService
                .contributors("square", "retrofit");
        List<Contributor> contributors = call.execute().body();

        System.out.println("List of contributors:");
        contributors.forEach(contributor ->
                System.out.println(String.format("%s (%s)",
                        contributor.login,
                        contributor.contributions)));
    }
}
