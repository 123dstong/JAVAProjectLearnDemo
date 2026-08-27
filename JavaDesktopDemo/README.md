# JavaFX 桌面应用示例

这是一个使用 JavaFX 开发的桌面应用程序示例，用于学习 Java GUI 开发。

## 项目结构

```
JavaDesktopDemo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── desktop/
│       │               ├── MainApp.java              # 主应用类
│       │               ├── controller/
│       │               │   ├── MainController.java   # 主界面控制器
│       │               │   └── UserController.java   # 用户管理控制器
│       │               └── model/
│       │                   └── User.java             # 用户模型类
│       └── resources/
│           ├── fxml/                                 # FXML布局文件
│           │   ├── MainView.fxml                     # 主界面
│           │   ├── HomeView.fxml                     # 首页
│           │   ├── UserManagementView.fxml           # 用户管理页
│           │   ├── StatisticsView.fxml               # 数据统计页
│           │   ├── SettingsView.fxml                 # 系统设置页
│           │   └── AboutView.fxml                    # 关于页面
│           └── css/
│               └── style.css                         # 样式表
└── pom.xml                                           # Maven配置
```

## 环境要求

- JDK 1.8 或更高版本（JavaFX 8.0 内置）
- Maven 3.6 或更高版本
- IntelliJ IDEA 2025.3.5

## 如何运行

### 方法一：使用 IntelliJ IDEA
1. 打开 IntelliJ IDEA
2. 选择 `File` → `Open`
3. 选择 `JavaDesktopDemo` 文件夹
4. 等待 Maven 依赖下载完成
5. 运行 `MainApp.java` 文件

### 方法二：使用 Maven 命令
```bash
# 进入项目目录
cd JavaDesktopDemo

# 编译并运行
mvn javafx:run
```

### 方法三：打包后运行
```bash
# 打包
mvn clean package

# 运行
java -cp target/classes com.example.desktop.MainApp
```

## 功能特性

### 1. 侧边栏导航
- 首页
- 用户管理
- 数据统计
- 系统设置
- 关于

### 2. 用户管理
- 用户列表展示
- 添加用户
- 删除用户
- 搜索用户
- 刷新列表

### 3. 数据统计
- 统计卡片展示
- 图表区域（可扩展）

### 4. 系统设置
- 基本设置
- 显示设置
- 主题选择

## 技术要点

### 1. MVC 架构
- **Model**: `User.java` - 数据模型
- **View**: `*.fxml` - 界面布局
- **Controller**: `*Controller.java` - 业务逻辑

### 2. FXML 布局
- 使用FXML声明式定义界面
- 支持CSS样式分离
- 便于维护和修改

### 3. CSS 样式
- 护眼绿色主题
- 响应式设计
- 统一的视觉风格

### 4. 事件处理
- `@FXML` 注解绑定事件
- 支持按钮点击事件
- 支持键盘快捷键

## 学习内容

### 1. JavaFX 基础
- Stage（窗口）
- Scene（场景）
- Node（节点）

### 2. 布局容器
- VBox（垂直布局）
- HBox（水平布局）
- BorderPane（边框布局）
- StackPane（堆叠布局）

### 3. 常用控件
- Label（标签）
- Button（按钮）
- TextField（文本框）
- TableView（表格）
- ComboBox（下拉框）
- CheckBox（复选框）

### 4. 样式美化
- CSS样式表
- 内联样式
- 动态样式

## 扩展练习

1. **添加数据库功能**
   - 集成 SQLite 或 MySQL
   - 实现数据持久化
   - 完整的增删改查

2. **添加图表功能**
   - 集成 JFreeChart
   - 实现数据可视化
   - 导出图表功能

3. **添加文件操作**
   - 文件选择器
   - 文件读写
   - 导入导出功能

4. **添加网络功能**
   - HTTP 请求
   - WebSocket 通信
   - REST API 调用

5. **添加多语言支持**
   - 国际化 i18n
   - 语言切换
   - 资源文件管理

## 常见问题

### 1. JavaFX 相关错误
确保使用 JDK 1.8，因为 JavaFX 在 JDK 8 中内置。
如果使用更高版本的 JDK，需要手动添加 JavaFX 依赖。

### 2. FXML 加载失败
检查 FXML 文件路径是否正确，确保文件在 resources 目录下。

### 3. 样式未生效
检查 CSS 文件路径是否正确，确保在 FXML 中正确引用。

## 相关资源

- [JavaFX 官方文档](https://openjfx.io/openjfx-docs/)
- [FXML 介绍](https://openjfx.io/openjfx-docs/#intro-fxml)
- [JavaFX CSS 参考](https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/doc-files/cssref.html)

## 许可证

本项目仅供学习参考使用。