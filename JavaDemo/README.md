# Java学习示例项目

这是一个用于学习Java基础知识的简单示例项目。

## 项目结构

```
JavaDemo/
├── src/
│   └── com/
│       └── example/
│           └── demo/
│               ├── HelloWorld.java      # 主类，包含main方法
│               ├── Person.java          # 人类，演示封装
│               ├── Student.java         # 学生类，演示继承
│               └── InvalidAgeException.java  # 自定义异常
└── README.md
```

## 如何用IntelliJ IDEA打开项目

1. 打开IntelliJ IDEA 2025.3.5
2. 选择 "Open" 或 "Open Project"
3. 浏览到 `JavaDemo` 文件夹并选择它
4. 点击 "OK" 或 "Open"
5. 等待IDEA导入项目并建立索引

## 运行项目

1. 在项目视图中，展开 `src/com/example/demo` 目录
2. 右键点击 `HelloWorld.java` 文件
3. 选择 "Run 'HelloWorld.main()'"
4. 控制台将显示输出结果

## 学习内容

本示例涵盖了以下Java基础概念：

### 1. 基本数据类型
- 整数类型：byte, short, int, long
- 浮点类型：float, double
- 字符类型：char
- 布尔类型：boolean

### 2. 控制流
- if-else语句
- for循环
- while循环
- switch语句

### 3. 数组和集合
- 数组的使用
- ArrayList的使用
- HashMap的使用

### 4. 面向对象编程
- 类和对象
- 封装（私有字段和getter/setter方法）
- 继承（extends关键字）
- 方法重写（@Override注解）
- toString()方法

### 5. 异常处理
- try-catch块
- 常见异常类型
- 自定义异常
- throws关键字

## 扩展练习

1. 尝试修改Person类，添加更多属性（如地址、电话）
2. 创建更多的子类，如Teacher类
3. 添加更多的集合操作示例
4. 尝试使用Java 8的Stream API
5. 添加文件读写操作示例

## 注意事项

- 确保已安装Java JDK（推荐JDK 11或更高版本）
- IntelliJ IDEA会自动识别项目结构
- 如果遇到编译错误，检查JDK配置是否正确