package com.berserk.open_api_projects.cat_facts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactsService {
    @Value("${cat_fact.url}")
    private String catFactUrl;

    public String getCatFact() {
        RestTemplate restTemplate = new RestTemplate();
        CatFact catFact = restTemplate.getForObject(catFactUrl, CatFact.class);
        assert catFact != null;
        return catFact.getFact();
    }
}
