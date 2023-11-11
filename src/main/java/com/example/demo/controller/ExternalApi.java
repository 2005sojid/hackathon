package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Controller
public class ExternalApi {

    @GetMapping("/articles")
    public String articles(Model model){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("X-Api-Key", "L+yYBfrZsqO/6RfMqGgNdQ==C9F4avSony9kQcWn");
        String url = "https://api.api-ninjas.com/v1/facts?limit=10";
        HttpEntity<List<String>> http = new HttpEntity<List<String>>(httpHeaders);
        List res = restTemplate.exchange(url,HttpMethod.GET, http, List.class).getBody();
        model.addAttribute("api", res);
        return "articles";
    }
}
