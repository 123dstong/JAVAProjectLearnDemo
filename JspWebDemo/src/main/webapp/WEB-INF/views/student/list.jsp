<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生管理 - JSP Web</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Microsoft YaHei', sans-serif; background: #E8F5E9; min-height: 100vh; padding: 20px; }
        .container { max-width: 1000px; margin: 0 auto; }
        .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        h1 { color: #1B5E20; font-size: 24px; }
        .btn { padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; font-size: 14px; color: white; }
        .btn-primary { background: #2196F3; }
        .btn-primary:hover { background: #1976D2; }
        .btn-danger { background: #f44336; }
        .btn-danger:hover { background: #d32f2f; }
        .btn-default { background: #9E9E9E; }
        .btn-default:hover { background: #757575; }
        .card { background: white; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); padding: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th { background: #607D8B; color: white; padding: 12px; text-align: left; }
        td { padding: 12px; border-bottom: 1px solid #eee; }
        tr:hover { background: #f5f5f5; }
        .action-btn { padding: 5px 10px; border: none; border-radius: 3px; cursor: pointer; color: white; font-size: 12px; text-decoration: none; }
        .edit-btn { background: #2196F3; }
        .delete-btn { background: #f44336; }
        .back-link { display: inline-block; margin-top: 20px; color: #4CAF50; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>学生管理</h1>
            <div>
                <button class="btn btn-primary" onclick="location.href='student?action=add'">添加学生</button>
                <button class="btn btn-default" onclick="location.href='student'">刷新</button>
            </div>
        </div>

        <div class="card">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>班级</th>
                        <th>成绩</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${studentList}" var="student">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.studentNo}</td>
                            <td>${student.name}</td>
                            <td>${student.className}</td>
                            <td>${student.score}</td>
                            <td>
                                <a href="student?action=edit&id=${student.id}" class="action-btn edit-btn">编辑</a>
                                <a href="student?action=delete&id=${student.id}" class="action-btn delete-btn" onclick="return confirm('确定删除吗？')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty studentList}">
                        <tr>
                            <td colspan="6" style="text-align: center; padding: 20px; color: #999;">暂无数据</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <a href="index.jsp" class="back-link">← 返回首页</a>
    </div>
</body>
</html>