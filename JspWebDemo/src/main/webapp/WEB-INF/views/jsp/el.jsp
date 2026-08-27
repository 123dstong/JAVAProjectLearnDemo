<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL表达式示例 - JSP Web</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Microsoft YaHei', sans-serif; background: #E8F5E9; min-height: 100vh; padding: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        h1 { color: #1B5E20; margin-bottom: 20px; }
        .card { background: white; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); padding: 20px; margin-bottom: 20px; }
        .card h2 { color: #2196F3; margin-bottom: 15px; font-size: 18px; }
        .code { background: #f5f5f5; padding: 15px; border-radius: 5px; font-family: monospace; margin: 10px 0; }
        .result { background: #C8E6C9; padding: 10px 15px; border-radius: 5px; margin: 10px 0; }
        .back-link { display: inline-block; margin-top: 20px; color: #4CAF50; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h1>EL 表达式示例</h1>

        <%-- 设置请求属性 --%>
        <jsp:useBean id="user" class="com.example.web.User" scope="request"/>
        <jsp:setProperty property="id" value="1" name="user"/>
        <jsp:setProperty property="name" value="张三" name="user"/>
        <jsp:setProperty property="email" value="zhangsan@example.com" name="user"/>
        <jsp:setProperty property="phone" value="13800138001" name="user"/>
        <jsp:setProperty property="age" value="25" name="user"/>

        <%-- 示例1: 基本输出 --%>
        <div class="card">
            <h2>1. 基本输出 ${}</h2>
            <div class="code">
                用户名: ${user.name}<br>
                邮箱: ${user.email}<br>
                电话: ${user.phone}<br>
                年龄: ${user.age}
            </div>
            <div class="result">
                <strong>结果:</strong><br>
                用户名: ${user.name}<br>
                邮箱: ${user.email}<br>
                电话: ${user.phone}<br>
                年龄: ${user.age}
            </div>
        </div>

        <%-- 示例2: 获取请求参数 --%>
        <div class="card">
            <h2>2. 获取请求参数 ${param}</h2>
            <div class="code">
                URL参数值: ${param.name}
            </div>
            <div class="result">
                <strong>说明:</strong> ${empty param.name ? '没有传递name参数' : 'name参数值为: '.concat(param.name)}
            </div>
        </div>

        <%-- 示例3: 获取隐式对象 --%>
        <div class="card">
            <h2>3. 隐式对象</h2>
            <div class="code">
                请求URL: ${pageContext.request.requestURL}<br>
                上下文路径: ${pageContext.request.contextPath}<br>
                会话ID: ${pageContext.request.session.id}
            </div>
            <div class="result">
                <strong>结果:</strong><br>
                请求URL: ${pageContext.request.requestURL}<br>
                上下文路径: ${pageContext.request.contextPath}<br>
                会话ID: ${pageContext.request.session.id}
            </div>
        </div>

        <%-- 示例4: 运算符 --%>
        <div class="card">
            <h2>4. EL运算符</h2>
            <div class="code">
                10 + 5 = ${10 + 5}<br>
                10 - 5 = ${10 - 5}<br>
                10 * 5 = ${10 * 5}<br>
                10 / 5 = ${10 / 5}<br>
                10 % 3 = ${10 % 3}<br>
                10 > 5 ? "是" : "否" = ${10 > 5 ? "是" : "否"}
            </div>
            <div class="result">
                <strong>结果:</strong><br>
                10 + 5 = ${10 + 5}<br>
                10 - 5 = ${10 - 5}<br>
                10 * 5 = ${10 * 5}<br>
                10 / 5 = ${10 / 5}<br>
                10 % 3 = ${10 % 3}<br>
                条件判断: ${10 > 5 ? "是" : "否"}
            </div>
        </div>

        <a href="index.jsp" class="back-link">← 返回首页</a>
    </div>
</body>
</html>