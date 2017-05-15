package com.quickrental.restful.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */

@RestController
public class TestController {

    @GetMapping("/public")
    @CrossOrigin
    public String publicService() {
        return "This message is public";
    }

    @GetMapping("/secret")
    @CrossOrigin
    public String secretService() {
        return "A secret message";
    }
}
