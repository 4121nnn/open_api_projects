package com.berserk.open_api_projects.cat_facts;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/cat-facts")
public class CatFactsController {
    CatFactsService catFactsService;
    public CatFactsController(CatFactsService catFactsService){
        this.catFactsService = catFactsService;
    }

    @GetMapping
    public String getFact(){
        return catFactsService.getCatFact();
    }

    @GetMapping("/all")
    public CatFact[] getCatFacts() {
        return catFactsService.getCatFacts();
    }
}
