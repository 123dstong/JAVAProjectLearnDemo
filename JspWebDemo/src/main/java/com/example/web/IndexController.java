package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.jsp";
    }
}