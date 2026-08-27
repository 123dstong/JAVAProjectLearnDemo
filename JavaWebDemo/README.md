# Spring Boot Web Demo

这是一个简单的Spring Boot Web示例项目，用于学习Java Web开发。

## 项目结构

```
JavaWebDemo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── webdemo/
│   │   │               ├── WebDemoApplication.java      # 主应用类
│   │   │               ├── controller/
│   │   │               │   ├── HomeController.java      # 页面控制器
│   │   │               │   └── ApiController.java       # REST API控制器
│   │   │               └── exception/
│   │   │                   └── GlobalExceptionHandler.java  # 全局异常处理
│   │   └── resources/
│   │       ├── application.yml                           # 配置文件
│   │       ├── static/                                   # 静态资源
│   │       │   └── static.html
│   │       └── templates/                                # 模板页面
│   │           ├── index.html
│   │           ├── form.html
│   │           └── error.html
│   └── test/                                             # 测试代码
├── pom.xml                                               # Maven配置
└── README.md                                             # 项目说明
```

## 环境要求

- JDK 1.8 或更高版本
- Maven 3.6 或更高版本
- IntelliJ IDEA 2025.3.5

## 如何运行

### 方法一：使用Maven命令
```bash
# 进入项目目录
cd JavaWebDemo

# 编译并运行
mvn spring-boot:run
```

### 方法二：使用IntelliJ IDEA
1. 打开 IntelliJ IDEA
2. 选择 `File` → `Open`
3. 选择 `JavaWebDemo` 文件夹
4. 等待Maven依赖下载完成
5. 运行 `WebDemoApplication.java` 文件

### 方法三：打包后运行
```bash
# 打包
mvn clean package

# 运行
java -jar target/webdemo-1.0.0.jar
```

## 访问地址

启动成功后，手动在浏览器中访问以下地址：

- **首页**: http://localhost:8080
- **Hello接口**: http://localhost:8080/hello
- **用户页面**: http://localhost:8080/user/张三
- **表单页面**: http://localhost:8080/form
- **用户列表API**: http://localhost:8080/api/users
- **静态页面**: http://localhost:8080/static/static.html

## API接口

### 页面接口
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/` | 首页 |
| GET | `/hello` | Hello接口 |
| GET | `/user/{name}` | 用户页面 |
| GET | `/form` | 表单页面 |
| POST | `/submit` | 提交表单 |

### REST API
| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/users` | 获取所有用户 |
| GET | `/api/users/{id}` | 根据ID获取用户 |
| POST | `/api/users` | 创建用户 |
| PUT | `/api/users/{id}` | 更新用户 |
| DELETE | `/api/users/{id}` | 删除用户 |
| GET | `/api/users/search?keyword=xxx` | 搜索用户 |

## 示例代码

### 1. REST API调用示例
```bash
# 获取所有用户
curl http://localhost:8080/api/users

# 创建用户
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"张三","email":"zhangsan@example.com"}'

# 更新用户
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"李四","email":"lisi@example.com"}'

# 删除用户
curl -X DELETE http://localhost:8080/api/users/1
```

### 2. 前端调用示例
```javascript
// 获取用户列表
fetch('/api/users')
  .then(response => response.json())
  .then(data => console.log(data));

// 创建用户
fetch('/api/users', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({
    name: '张三',
    email: 'zhangsan@example.com'
  })
})
.then(response => response.json())
.then(data => console.log(data));
```

## 学习内容

### 1. Spring Boot基础
- 主应用类注解 `@SpringBootApplication`
- 配置文件 `application.yml`
- 启动流程

### 2. Web开发
- 控制器注解 `@Controller` 和 `@RestController`
- 请求映射 `@GetMapping`、`@PostMapping`
- 路径参数 `@PathVariable`
- 请求参数 `@RequestParam`
- 请求体 `@RequestBody`

### 3. 模板引擎
- Thymeleaf基本语法
- 动态页面渲染
- 表单处理

### 4. RESTful API
- REST架构风格
- JSON数据交互
- CRUD操作实现

### 5. 异常处理
- 全局异常处理器 `@RestControllerAdvice`
- 异常处理注解 `@ExceptionHandler`
- 统一错误响应格式

## 扩展练习

1. **添加数据库功能**
   - 集成Spring Data JPA
   - 创建实体类和Repository
   - 实现数据持久化

2. **添加用户认证**
   - 集成Spring Security
   - 实现登录功能
   - 权限控制

3. **添加前端框架**
   - 集成Vue.js或React
   - 实现前后端分离
   - 使用Axios进行API调用

4. **添加日志功能**
   - 集成Logback
   - 配置日志级别
   - 记录请求日志

5. **添加API文档**
   - 集成Swagger
   - 生成API文档
   - 在线测试API

## 常见问题

### 1. JDK版本不兼容
如果遇到 `无法编译为 JVM 目标 17` 错误，说明你的JDK版本不是17+。
本项目已配置为兼容 JDK 1.8，确保IDEA中项目SDK设置为 JDK 1.8：
1. `File` → `Project Structure` → `Project`
2. 设置 `Project SDK` 为 1.8
3. 设置 `Project language level` 为 8

### 2. 端口被占用
修改 `application.yml` 中的端口配置：
```yaml
server:
  port: 8081
```

### 3. 依赖下载失败
```bash
# 清理本地仓库缓存
mvn clean install -DskipTests

# 或者使用阿里云镜像
# 在pom.xml中添加阿里云仓库
```

### 4. 中文乱码
确保文件编码为UTF-8，在 `application.yml` 中添加：
```yaml
spring:
  thymeleaf:
    encoding: UTF-8
```

## 技术栈

- **后端**: Spring Boot 2.7.18
- **模板引擎**: Thymeleaf
- **构建工具**: Maven
- **JDK版本**: 1.8
- **IDE**: IntelliJ IDEA 2025.3.5

## 相关资源

- [Spring Boot官方文档](https://spring.io/projects/spring-boot)
- [Thymeleaf官方文档](https://www.thymeleaf.org/)
- [Maven官方文档](https://maven.apache.org/)

## 许可证

本项目仅供学习参考使用。