<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${empty user ? '添加用户' : '编辑用户'} - JSP Web</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Microsoft YaHei', sans-serif; background: #E8F5E9; min-height: 100vh; display: flex; justify-content: center; align-items: center; }
        .container { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); max-width: 500px; width: 90%; }
        h1 { color: #1B5E20; margin-bottom: 30px; text-align: center; font-size: 24px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; color: #555; font-weight: bold; }
        input[type="text"], input[type="email"], input[type="tel"], input[type="number"] {
            width: 100%; padding: 12px; border: 2px solid #ddd; border-radius: 5px; font-size: 16px;
        }
        input:focus { border-color: #4CAF50; outline: none; }
        .btn-group { display: flex; gap: 10px; margin-top: 30px; }
        .btn { flex: 1; padding: 12px; border: none; border-radius: 5px; font-size: 16px; font-weight: bold; cursor: pointer; }
        .btn-primary { background: #4CAF50; color: white; }
        .btn-primary:hover { background: #45a049; }
        .btn-secondary { background: #f5f5f5; color: #333; }
        .btn-secondary:hover { background: #e5e5e5; }
        .back-link { display: block; text-align: center; margin-top: 20px; color: #4CAF50; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h1>${empty user ? '添加用户' : '编辑用户'}</h1>
        
        <form action="user" method="post">
            <input type="hidden" name="action" value="${empty user ? 'insert' : 'update'}">
            <input type="hidden" name="id" value="${user.id}">
            
            <div class="form-group">
                <label for="name">姓名:</label>
                <input type="text" id="name" name="name" value="${user.name}" required>
            </div>
            
            <div class="form-group">
                <label for="email">邮箱:</label>
                <input type="email" id="email" name="email" value="${user.email}" required>
            </div>
            
            <div class="form-group">
                <label for="phone">电话:</label>
                <input type="tel" id="phone" name="phone" value="${user.phone}">
            </div>
            
            <div class="form-group">
                <label for="age">年龄:</label>
                <input type="number" id="age" name="age" value="${user.age}" min="1" max="150">
            </div>
            
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='user'">取消</button>
            </div>
        </form>
    </div>
</body>
</html>