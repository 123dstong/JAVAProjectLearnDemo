# JAVA项目学习案例
JAVA 初学者 学习控制台、WEB、客户端开发

# 项目技术栈汇总表

## 6个项目技术栈对比

| 项目                | 目录              | 核心框架           | 关键技术                                 | 运行方式              | 端口 |
| ------------------- | ----------------- | ------------------ | ---------------------------------------- | --------------------- | ---- |
| **Java 基础**       | `JavaDemo`        | -                  | Java 8 标准库                            | 直接运行 main         | -    |
| **Spring Boot Web** | `JavaWebDemo`     | Spring Boot 2.7.18 | Thymeleaf、MVC、REST API、全局异常       | `mvn spring-boot:run` | 8088 |
| **IDEA 护眼模式**   | 配置文件          | IDEA 2025.3.5      | 自定义 Color Scheme、UI 主题、字体       | 重启 IDEA 生效        | -    |
| **JavaFX 桌面**     | `JavaDesktopDemo` | JavaFX 8           | FXML、CSS、MVC、Maven                    | `mvn javafx:run`      | -    |
| **Swing 桌面**      | `SwingDemo`       | Swing (JDK内置)    | JFrame、JTable、JMenuBar、事件监听       | 运行 main             | -    |
| **JSP Web**         | `JspWebDemo`      | Spring Boot 2.7.18 | JSP、JSTL、Servlet、EL表达式、内嵌Tomcat | 运行 Application.main | 9090 |

---

## 统一技术栈

| 维度         | 统一规范               |
| ------------ | ---------------------- |
| **JDK版本**  | 1.8.0_333              |
| **构建工具** | Maven 3.6+             |
| **IDE**      | IntelliJ IDEA 2025.3.5 |
| **编码**     | UTF-8                  |
| **护眼主题** | 绿色系 #E8F5E9 背景    |
| **字体**     | Microsoft YaHei 14px   |

---

## 核心技术点速查

| 领域         | 涉及技术                                                     |
| ------------ | ------------------------------------------------------------ |
| **Java基础** | 数据类型、集合、泛型、异常、IO、多线程基础                   |
| **面向对象** | 封装、继承、多态、接口、抽象类、内部类                       |
| **Web开发**  | Spring Boot、MVC、RESTful、Thymeleaf、JSP、Servlet、Filter、Interceptor |
| **前端模板** | Thymeleaf、JSP、JSTL(c:if/choose/forEach)、EL表达式          |
| **桌面开发** | JavaFX(FXML/CSS)、Swing(组件/布局/事件)                      |
| **数据处理** | JavaBean、List/Map、JSTL标签、EL表达式                       |
| **异常处理** | try-catch、自定义异常、全局异常处理器                        |
| **配置管理** | application.yml、application.properties、web.xml             |
| **构建部署** | Maven、内嵌Tomcat、jar/war打包                               |

---

## 运行命令速查

```bash
# Java 基础
cd JavaDemo && javac src/com/example/demo/HelloWorld.java && java -cp src com.example.demo.HelloWorld

# Spring Boot Web
cd JavaWebDemo && mvn spring-boot:run

# JavaFX
cd JavaDesktopDemo && mvn javafx:run

# Swing
cd SwingDemo && 运行 MainApp.main()

# JSP Web (Spring Boot)
cd JspWebDemo && 运行 Application.main()
```

---

## 访问地址

| 项目            | 地址                  |
| --------------- | --------------------- |
| Spring Boot Web | http://localhost:8088 |
| JSP Web         | http://localhost:9090 |
| JavaFX / Swing  | 桌面应用直接运行      |
