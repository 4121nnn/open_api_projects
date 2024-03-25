package com.berserk.open_api_projects.cat_facts;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
