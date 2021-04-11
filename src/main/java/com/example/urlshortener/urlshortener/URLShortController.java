package com.example.urlshortener.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class URLShortController {

    private final URLShortService urlShortService;

    @Autowired
    public URLShortController(URLShortService urlShortService) {
        this.urlShortService = urlShortService;
    }

    @PostMapping(path = "api/v1/save")
    public String saveApi(@RequestBody URLMap urlMap){
        urlShortService.saveapi(urlMap);
        return "saved";
    }
    @GetMapping(path = {"/","{data}"})
    public URLMap getBasicURL(@PathVariable(required = false, name="data") String data){
        if (data != null) {
            System.out.println(data);
            return urlShortService.getApi(data);
        }
        throw new IllegalStateException("URL Not found");
    }

    @GetMapping(path = "api/v1/get")
    @ResponseBody
    public URLMap directGetApi(@RequestParam(name = "mapurl") String mapurl) {
        return urlShortService.getApi(mapurl);
    }
}
