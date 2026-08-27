<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

        <div class="card">
            <h2>1. 基本运算</h2>
            <div class="code">10 + 5 = \${10 + 5}</div>
            <div class="result">
                <strong>结果:</strong> 10 + 5 = ${10 + 5}
            </div>
        </div>

        <div class="card">
            <h2>2. 字符串输出</h2>
            <div class="code">\${'Hello JSP'}</div>
            <div class="result">
                <strong>结果:</strong> ${'Hello JSP'}
            </div>
        </div>

        <div class="card">
            <h2>3. 获取请求参数</h2>
            <div class="code">\${param.name}</div>
            <div class="result">
                <strong>结果:</strong> ${param.name}
            </div>
        </div>

        <div class="card">
            <h2>4. 条件判断</h2>
            <div class="code">\${10 > 5 ? '是' : '否'}</div>
            <div class="result">
                <strong>结果:</strong> ${10 > 5 ? '是' : '否'}
            </div>
        </div>

        <div class="card">
            <h2>5. 隐式对象</h2>
            <div class="code">\${pageContext.request.contextPath}</div>
            <div class="result">
                <strong>结果:</strong> ${pageContext.request.contextPath}
            </div>
        </div>

        <a href="/" class="back-link">&larr; 返回首页</a>
    </div>
</body>
</html>