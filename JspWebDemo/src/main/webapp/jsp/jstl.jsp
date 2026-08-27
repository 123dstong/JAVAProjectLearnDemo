<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL标签示例 - JSP Web</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Microsoft YaHei', sans-serif; background: #E8F5E9; min-height: 100vh; padding: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        h1 { color: #1B5E20; margin-bottom: 20px; }
        .card { background: white; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); padding: 20px; margin-bottom: 20px; }
        .card h2 { color: #FF9800; margin-bottom: 15px; font-size: 18px; }
        .code { background: #f5f5f5; padding: 15px; border-radius: 5px; font-family: monospace; margin: 10px 0; }
        .result { background: #C8E6C9; padding: 10px 15px; border-radius: 5px; margin: 10px 0; }
        .back-link { display: inline-block; margin-top: 20px; color: #4CAF50; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h1>JSTL 标签示例</h1>

        <%-- 设置数据 --%>
        <c:set var="score" value="85"/>
        <c:set var="name" value="张三"/>

        <%-- 示例1: c:if 条件判断 --%>
        <div class="card">
            <h2>1. c:if 条件判断</h2>
            <div class="code">
                &lt;c:if test="${score >= 80}"&gt;<br>
                &nbsp;&nbsp;成绩良好<br>
                &lt;/c:if&gt;
            </div>
            <div class="result">
                <strong>结果:</strong>
                <c:if test="${score >= 90}">
                    成绩优秀
                </c:if>
                <c:if test="${score >= 80 && score < 90}">
                    成绩良好 (当前分数: ${score})
                </c:if>
                <c:if test="${score < 80}">
                    成绩需要提高
                </c:if>
            </div>
        </div>

        <%-- 示例2: c:choose 条件判断 --%>
        <div class="card">
            <h2>2. c:choose 多条件判断</h2>
            <div class="code">
                &lt;c:choose&gt;<br>
                &nbsp;&nbsp;&lt;c:when test="${score >= 90}"&gt;优秀&lt;/c:when&gt;<br>
                &nbsp;&nbsp;&lt;c:when test="${score >= 80}"&gt;良好&lt;/c:when&gt;<br>
                &nbsp;&nbsp;&lt;c:otherwise&gt;其他&lt;/c:otherwise&gt;<br>
                &lt;/c:choose&gt;
            </div>
            <div class="result">
                <strong>结果:</strong>
                <c:choose>
                    <c:when test="${score >= 90}">优秀</c:when>
                    <c:when test="${score >= 80}">良好</c:when>
                    <c:when test="${score >= 70}">中等</c:when>
                    <c:otherwise>需要提高</c:otherwise>
                </c:choose>
            </div>
        </div>

        <%-- 示例3: c:forEach 循环 --%>
        <div class="card">
            <h2>3. c:forEach 循环</h2>
            <div class="code">
                &lt;c:forEach begin="1" end="5" var="i"&gt;<br>
                &nbsp;&nbsp;${'${i}'}<br>
                &lt;/c:forEach&gt;
            </div>
            <div class="result">
                <strong>结果:</strong>
                <c:forEach begin="1" end="5" var="i">
                    ${i} 
                </c:forEach>
            </div>
        </div>

        <%-- 示例4: c:forEach 遍历集合 --%>
        <div class="card">
            <h2>4. c:forEach 遍历集合</h2>
            <c:set var="fruits" value="苹果,香蕉,橙子"/>
            <div class="code">
                &lt;c:forEach items="${fruits}" var="fruit"&gt;<br>
                &nbsp;&nbsp;${'${fruit}'}<br>
                &lt;/c:forEach&gt;
            </div>
            <div class="result">
                <strong>结果:</strong>
                <c:forEach items="${fruits}" var="fruit" varStatus="status">
                    ${fruit}${status.last ? '' : ', '}
                </c:forEach>
            </div>
        </div>

        <%-- 示例5: c:out 输出 --%>
        <div class="card">
            <h2>5. c:out 输出</h2>
            <c:set var="html" value="<b>加粗文本</b>"/>
            <div class="code">
                &lt;c:out value="${'${html}'}" escapeXml="false"/&gt;
            </div>
            <div class="result">
                <strong>结果:</strong> <c:out value="${html}" escapeXml="false"/>
            </div>
        </div>

        <a href="/" class="back-link">&larr; 返回首页</a>
    </div>
</body>
</html>