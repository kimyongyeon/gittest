package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yongyeonkim on 2016. 4. 24..
 */
@Controller
public class MainController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello world";
    }
}
