package com.techtraversal.springboot.retrofit.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Contributor {

    public long id;
    public String login;
    public int contributions;

    public Contributor() {}

    public Contributor(Long id, String login, int contributions) {
        this.id = id;
        this.login = login;
        this.contributions = contributions;
    }

    public String getLogin() {
        return login;
    }

    public int getContributions() {
        return contributions;
    }
}
