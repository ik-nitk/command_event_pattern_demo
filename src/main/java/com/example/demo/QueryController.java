package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class QueryController {

    final private QueryService queryService;

    @Autowired
    public QueryController(final QueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping("/store")
    public Collection<String> query(@RequestParam(value="key") String key) {
        return queryService.query(key);
    }
}
