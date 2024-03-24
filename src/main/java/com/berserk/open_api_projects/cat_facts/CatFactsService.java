package com.berserk.open_api_projects.cat_facts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public CatFact[] getCatFacts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://catfact.ninja/facts", CatFact[].class);
    }
}
