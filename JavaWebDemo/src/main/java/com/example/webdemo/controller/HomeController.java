package com.example.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    /**
     * 首页
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Spring Boot Web Demo");
        model.addAttribute("message", "欢迎学习Spring Boot Web开发!");
        return "index";
    }

    /**
     * 简单页面
     */
    @GetMapping("/hello")
    @ResponseBody
    public Map<String, Object> hello() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "Hello, Spring Boot!");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    /**
     * 带参数的页面
     */
    @GetMapping("/user/{name}")
    @ResponseBody
    public Map<String, Object> user(@PathVariable String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("username", name);
        result.put("message", "欢迎, " + name + "!");
        return result;
    }

    /**
     * 表单页面
     */
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title", "用户注册");
        return "form";
    }

    /**
     * 处理表单提交
     */
    @PostMapping("/submit")
    @ResponseBody
    public Map<String, Object> submit(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam(required = false) String phone) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("username", username);
        result.put("email", email);
        result.put("phone", phone);
        result.put("message", "注册成功!");
        return result;
    }

    /**
     * 返回JSON数据
     */
    @GetMapping("/users/list")
    @ResponseBody
    public Map<String, Object> getUsers() {
        List<Map<String, Object>> users = new ArrayList<>();

        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 1);
        user1.put("name", "张三");
        user1.put("age", 25);
        users.add(user1);

        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 2);
        user2.put("name", "李四");
        user2.put("age", 30);
        users.add(user2);

        Map<String, Object> user3 = new HashMap<>();
        user3.put("id", 3);
        user3.put("name", "王五");
        user3.put("age", 28);
        users.add(user3);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", users);
        result.put("total", users.size());
        return result;
    }

    /**
     * 错误页面
     */
    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("title", "错误页面");
        model.addAttribute("message", "这是一个错误示例页面");
        return "error";
    }
}