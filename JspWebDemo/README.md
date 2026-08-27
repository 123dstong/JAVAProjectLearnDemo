# JSP Web 应用示例

这是一个使用 JSP + Servlet 开发的 Web 应用程序示例，类似于 .NET ASP.NET Web Forms。

## 项目结构

```
JspWebDemo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── web/
│       │               ├── User.java                 # 用户实体类
│       │               ├── Student.java              # 学生实体类
│       │               ├── UserServlet.java          # 用户Servlet
│       │               ├── StudentServlet.java       # 学生Servlet
│       │               └── CharacterEncodingFilter.java  # 编码过滤器
│       └── webapp/
│           ├── index.jsp                             # 首页
│           ├── WEB-INF/
│           │   └── web.xml                           # Web配置文件
│           ├── user/
│           │   ├── list.jsp                          # 用户列表页
│           │   └── form.jsp                          # 用户表单页
│           ├── student/
│           │   └── list.jsp                          # 学生列表页
│           └── jsp/
│               ├── el.jsp                            # EL表达式示例
│               └── jstl.jsp                          # JSTL标签示例
└── pom.xml                                           # Maven配置
```

## 环境要求

- JDK 1.8 或更高版本
- Maven 3.6 或更高版本
- IntelliJ IDEA 2025.3.5

## 如何运行

### 方法一：使用 Spring Boot 启动（推荐）

直接在 IDEA 中运行 `Application.java` 文件即可！

1. 打开 IntelliJ IDEA
2. 打开 `Application.java` 文件
3. 点击运行按钮
4. 访问：http://localhost:8080

**无需安装 Tomcat，项目已内嵌 Tomcat！**

## JSP vs ASP.NET Web Forms 对比

| JSP/Servlet | ASP.NET Web Forms | 说明 |
|-------------|-------------------|------|
| JSP | .aspx | 页面文件 |
| Servlet | CodeBehind (.aspx.cs) | 后端代码 |
| JavaBean | Model | 数据模型 |
| web.xml | Web.config | 配置文件 |
| EL表达式 | <%# %> | 数据绑定 |
| JSTL | Server Controls | 标签库 |
| request.setAttribute | ViewState | 数据传递 |

## 功能特性

### 1. 用户管理
- 用户列表展示
- 添加用户
- 编辑用户
- 删除用户
- 搜索用户

### 2. 学生管理
- 学生列表展示

### 3. EL表达式示例
- 基本输出
- 获取请求参数
- 获取隐式对象
- 运算符

### 4. JSTL标签示例
- c:if 条件判断
- c:choose 多条件判断
- c:forEach 循环
- c:forTokens 分割字符串
- fmt 格式化标签

## 代码示例

### 1. JSP 页面
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <h1>用户列表</h1>
    <c:forEach items="${userList}" var="user">
        <p>${user.name} - ${user.email}</p>
    </c:forEach>
</body>
</html>
```

### 2. Servlet 控制器
```java
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置数据
        request.setAttribute("userList", userList);
        // 转发到JSP页面
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }
}
```

### 3. JavaBean 实体类
```java
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    
    // 无参构造方法（必须）
    public User() {}
    
    // Getter和Setter方法
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### 4. EL 表达式
```jsp
${user.name}              <!-- 输出属性 -->
${param.name}             <!-- 获取请求参数 -->
${10 + 5}                 <!-- 运算 -->
${empty list ? '空' : '有数据'}  <!-- 条件判断 -->
```

### 5. JSTL 标签
```jsp
<c:if test="${score >= 60}">及格</c:if>
<c:forEach items="${list}" var="item">${item}</c:forEach>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
```

## 学习内容

### 1. JSP 基础
- JSP 指令
- JSP 动作
- JSP 内置对象

### 2. Servlet 编程
- HttpServlet 类
- 请求处理
- 响应输出
- 转发和重定向

### 3. JavaBean 规范
- 无参构造方法
- Getter/Setter 方法
- Serializable 接口

### 4. EL 表达式
- 语法格式
- 隐式对象
- 运算符

### 5. JSTL 标签库
- core 核心标签
- fmt 格式化标签
- 函数标签

## 扩展练习

1. **添加数据库功能**
   - 集成 JDBC
   - 实现数据持久化
   - 完整的增删改查

2. **添加用户登录**
   - 登录页面
   - Session 管理
   - 权限控制

3. **添加文件上传**
   - 文件上传表单
   - Servlet 处理上传
   - 文件保存

4. **添加分页功能**
   - 分页查询
   - 分页显示
   - 导航按钮

## 常见问题

### 1. 中文乱码
确保在 Servlet 中设置编码：
```java
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
```

### 2. 404 错误
检查 URL 映射是否正确，确保 Servlet 配置正确。

### 3. 500 错误
检查 Java 代码是否有异常，查看 Tomcat 日志。

## 相关资源

- [JSP 官方文档](https://docs.oracle.com/javaee/7/tutorial/jsf003.htm)
- [Servlet 官方文档](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
- [JSTL 文档](https://docs.oracle.com/javaee/7/javaserverfaces/2.1/vdocs/docs/jstl/guide/tld-summary.html)

## 许可证

本项目仅供学习参考使用。