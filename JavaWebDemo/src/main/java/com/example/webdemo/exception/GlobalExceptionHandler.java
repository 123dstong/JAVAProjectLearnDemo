package com.example.webdemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理通用异常
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 500);
        result.put("message", "服务器内部错误: " + e.getMessage());
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    /**
     * 处理参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("message", "参数错误: " + e.getMessage());
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Map<String, Object> handleNullPointerException(NullPointerException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 500);
        result.put("message", "空指针异常");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }
}