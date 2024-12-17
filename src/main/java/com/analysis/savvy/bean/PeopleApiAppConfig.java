package com.analysis.savvy.bean;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PeopleApiAppConfig {

    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

}
