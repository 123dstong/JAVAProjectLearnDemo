<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Web 应用示例</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Microsoft YaHei', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; }
        .container { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); text-align: center; max-width: 600px; width: 90%; }
        h1 { color: #333; margin-bottom: 20px; font-size: 28px; }
        .info { color: #666; font-size: 16px; margin-bottom: 30px; }
        .menu { display: grid; grid-template-columns: repeat(2, 1fr); gap: 15px; margin-top: 30px; }
        .menu-item { background: #667eea; color: white; padding: 15px 20px; border-radius: 5px; text-decoration: none; transition: all 0.3s ease; font-weight: bold; }
        .menu-item:hover { background: #5a6fd6; transform: translateY(-3px); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }
        .menu-item.green { background: #4CAF50; }
        .menu-item.green:hover { background: #45a049; }
        .menu-item.orange { background: #FF9800; }
        .menu-item.orange:hover { background: #F57C00; }
        .features { text-align: left; margin-top: 30px; padding: 20px; background: #f5f5f5; border-radius: 5px; }
        .features h3 { color: #333; margin-bottom: 15px; }
        .features ul { list-style: none; }
        .features li { padding: 8px 0; border-bottom: 1px solid #ddd; }
        .features li:last-child { border-bottom: none; }
        .features li::before { content: "✓"; color: #4CAF50; margin-right: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>JSP Web 应用示例</h1>
        <p class="info">使用 Spring Boot 内嵌 Tomcat 启动</p>
        
        <div class="menu">
            <a href="user" class="menu-item">用户管理</a>
            <a href="student" class="menu-item green">学生管理</a>
            <a href="jsp/el.jsp" class="menu-item orange">EL表达式</a>
            <a href="jsp/jstl.jsp" class="menu-item">JSTL标签</a>
        </div>

        <div class="features">
            <h3>技术特性:</h3>
            <ul>
                <li>Spring Boot 内嵌 Tomcat</li>
                <li>JSP 页面动态渲染</li>
                <li>Servlet 控制器处理请求</li>
                <li>EL 表达式和 JSTL 标签</li>
            </ul>
        </div>
    </div>
</body>
</html>