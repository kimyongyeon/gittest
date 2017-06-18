package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yongyeonkim on 2016. 4. 23..
 */
@RestController
public class MainController {
    @RequestMapping(value = "/")
    public String index() {
        return "hello world";
    }
}
