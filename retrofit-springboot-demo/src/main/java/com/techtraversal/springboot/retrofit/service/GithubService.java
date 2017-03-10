package com.techtraversal.springboot.retrofit.service;

import com.techtraversal.springboot.retrofit.annotation.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;


@RetrofitClient
public interface GithubService {

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
}
