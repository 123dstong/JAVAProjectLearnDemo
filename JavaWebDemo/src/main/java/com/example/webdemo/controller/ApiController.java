package com.example.webdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private List<Map<String, Object>> userList = new ArrayList<>();

    public ApiController() {
        // 初始化示例数据
        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 1);
        user1.put("name", "张三");
        user1.put("email", "zhangsan@example.com");
        userList.add(user1);

        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 2);
        user2.put("name", "李四");
        user2.put("email", "lisi@example.com");
        userList.add(user2);
    }

    /**
     * 获取所有用户
     */
    @GetMapping("/users")
    public Map<String, Object> getAllUsers() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "获取成功");
        result.put("data", userList);
        result.put("total", userList.size());
        return result;
    }

    /**
     * 根据ID获取用户
     */
    @GetMapping("/users/{id}")
    public Map<String, Object> getUserById(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        for (Map<String, Object> user : userList) {
            if ((int) user.get("id") == id) {
                result.put("code", 200);
                result.put("message", "获取成功");
                result.put("data", user);
                return result;
            }
        }
        result.put("code", 404);
        result.put("message", "用户不存在");
        return result;
    }

    /**
     * 创建用户
     */
    @PostMapping("/users")
    public Map<String, Object> createUser(@RequestBody Map<String, Object> user) {
        Map<String, Object> result = new HashMap<>();
        int newId = userList.size() + 1;
        user.put("id", newId);
        userList.add(user);

        result.put("code", 201);
        result.put("message", "创建成功");
        result.put("data", user);
        return result;
    }

    /**
     * 更新用户
     */
    @PutMapping("/users/{id}")
    public Map<String, Object> updateUser(@PathVariable int id, @RequestBody Map<String, Object> updatedUser) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            Map<String, Object> user = userList.get(i);
            if ((int) user.get("id") == id) {
                updatedUser.put("id", id);
                userList.set(i, updatedUser);
                result.put("code", 200);
                result.put("message", "更新成功");
                result.put("data", updatedUser);
                return result;
            }
        }
        result.put("code", 404);
        result.put("message", "用户不存在");
        return result;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/users/{id}")
    public Map<String, Object> deleteUser(@PathVariable int id) {
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            Map<String, Object> user = userList.get(i);
            if ((int) user.get("id") == id) {
                userList.remove(i);
                result.put("code", 200);
                result.put("message", "删除成功");
                return result;
            }
        }
        result.put("code", 404);
        result.put("message", "用户不存在");
        return result;
    }

    /**
     * 搜索用户
     */
    @GetMapping("/users/search")
    public Map<String, Object> searchUsers(@RequestParam String keyword) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> foundUsers = new ArrayList<>();

        for (Map<String, Object> user : userList) {
            String name = (String) user.get("name");
            if (name.contains(keyword)) {
                foundUsers.add(user);
            }
        }

        result.put("code", 200);
        result.put("message", "搜索成功");
        result.put("data", foundUsers);
        result.put("total", foundUsers.size());
        return result;
    }
}